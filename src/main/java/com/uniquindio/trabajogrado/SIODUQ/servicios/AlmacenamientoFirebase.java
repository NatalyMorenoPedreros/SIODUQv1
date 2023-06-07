package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.uniquindio.trabajogrado.SIODUQ.logica.CredencialesFirebase;
import com.uniquindio.trabajogrado.SIODUQ.utilidades.Constantes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.jdbc.ReaderInputStream;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
public class AlmacenamientoFirebase {

    private StorageOptions opcionesAlmacenamiento;
    private String nombreCanal;
    private String idProyecto;

    public AlmacenamientoFirebase() {
    }

    public void inicializarFirebase() throws FileNotFoundException, IOException {
        InputStream cuentaServicio = crearCredencialesFirebase();
        this.opcionesAlmacenamiento = StorageOptions.newBuilder()
                .setProjectId(idProyecto)
                .setCredentials(GoogleCredentials.fromStream(cuentaServicio)).build();

    }

    private File convertirMultipartesArchivo(MultipartFile archivo) throws FileNotFoundException, IOException {
        File archivoConvertido = new File(Objects.requireNonNull(archivo.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(archivoConvertido);
        fos.write(archivo.getBytes());
        fos.close();

        return archivoConvertido;
    }

    private String generarNombreArchivo(MultipartFile archivo, String identificacionUsuario) {
        return new Date().getTime() + Objects.requireNonNull(identificacionUsuario + archivo.getOriginalFilename()).replace(" ", "_");
    }

    public String[] cargarArchivo(MultipartFile archivo, String identificacionUsuario) throws IOException {
        inicializarFirebase();

        File archivoCargar = convertirMultipartesArchivo(archivo);
        String nombreArchivo = generarNombreArchivo(archivo, identificacionUsuario);
        String uuid = UUID.randomUUID().toString();

        Storage almacenamiento = opcionesAlmacenamiento.getService();
        Map<String, String> map = new HashMap<>();
        map.put("firebaseStorageDownloadTokens", uuid);

        BlobId blobId = BlobId.of(nombreCanal, nombreArchivo);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setMetadata(map).setContentType(archivo.getContentType()).build();
        almacenamiento.create(blobInfo, archivo.getBytes());

        String url = Constantes.URL_FIREBASE_DESCARGA + nombreCanal + Constantes.URL_FIREBASE_DESCARGA_2 + nombreArchivo + Constantes.URL_FIREBASE_DESCARGA_3 + uuid;
        log.info("Archivo " + archivoCargar.toPath() + " se cargo al bucket " + nombreCanal + " como " + nombreArchivo);

        return new String[]{url, nombreArchivo};
    }

    private InputStream crearCredencialesFirebase() throws FileNotFoundException, IOException {
        CredencialesFirebase credenciasFirebase = new CredencialesFirebase();

        Properties propiedades = new Properties();
        propiedades.load(new FileReader(Constantes.URL_FIREBASE_CREDENCIALES));

        nombreCanal = propiedades.getProperty(Constantes.FIREBASE_BUCKET_NAME);
        idProyecto = propiedades.getProperty(Constantes.FIREBASE_PROJECT_ID);

        String llavePrivada = propiedades.getProperty(Constantes.FIREBASE_PRIVATE_KEY).replace("\\n", "\n");

        credenciasFirebase.setType(propiedades.getProperty(Constantes.FIREBASE_TYPE));
        credenciasFirebase.setProject_id(idProyecto);
        credenciasFirebase.setPrivate_key_id(propiedades.getProperty(Constantes.FIREBASE_PRIVATE_KEY_ID));
        credenciasFirebase.setPrivate_key(llavePrivada);
        credenciasFirebase.setClient_email(propiedades.getProperty(Constantes.FIREBASE_CLIENT_EMAIL));
        credenciasFirebase.setClient_id(propiedades.getProperty(Constantes.FIREBASE_CLIENT_ID));
        credenciasFirebase.setAuth_uri(propiedades.getProperty(Constantes.FIREBASE_AUTH_URI));
        credenciasFirebase.setToken_uri(propiedades.getProperty(Constantes.FIREBASE_TOKEN_URI));
        credenciasFirebase.setAuth_provider_x509_cert_url(propiedades.getProperty(Constantes.FIREBASE_AUTH_PROVIDER_X509_CERT_URL));
        credenciasFirebase.setClient_x509_cert_url(propiedades.getProperty(Constantes.FIREBASE_CLIENT_X509_CERT_URL));

        ObjectMapper mapeado = new ObjectMapper();
        String json = mapeado.writeValueAsString(credenciasFirebase);
        StringReader lectorJson = new StringReader(json);

        InputStream respuesta = new ReaderInputStream(lectorJson);
        return respuesta;
    }
}
