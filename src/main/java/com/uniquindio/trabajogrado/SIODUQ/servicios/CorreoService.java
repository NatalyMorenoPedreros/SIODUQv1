package com.uniquindio.trabajogrado.SIODUQ.servicios;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CorreoService {

    @Autowired
    private JavaMailSender correo;

    public void sendEmail(List<String> destinatarios, String asunto, String mensaje) {

        for (String destinatario : destinatarios) {
            SimpleMailMessage email = new SimpleMailMessage();

            email.setTo(destinatario);
            email.setSubject(asunto);
            email.setText(mensaje);

            try {
                correo.send(email);
            } catch (MailSendException e) {
                log.error("No se realizo la accion del envio de correo: " + e.getMessage());
            }
        }
    }
}
