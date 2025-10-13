package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entidades.*;
import org.example.servicios.CitaManager;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospitalPU");
        EntityManager em = emf.createEntityManager();

        Medico medico = null;
        Paciente paciente = null;

        try {
            // Primera transacción: persistir médico y paciente
            em.getTransaction().begin();

            medico = Medico.of(
                    "Juan",
                    "Perez",
                    "12345678",
                    LocalDate.of(1980, 5, 12),
                    TipoSangre.O_POSITIVO,
                    "MP-1234",
                    EspecialidadMedica.CARDIOLOGIA
            );
            em.persist(medico);

            paciente = Paciente.of(
                    "María",
                    "Gonzalez",
                    "23456789",
                    LocalDate.of(1990, 8, 3),
                    TipoSangre.A_POSITIVO,
                    "3412345678",
                    "Av Siempre Viva 123"
            );
            em.persist(paciente);

            em.getTransaction().commit();
            System.out.println("Datos persistidos con éxito. ID médico: " + medico.getId() + ", paciente: " + paciente.getId());

        } catch (Exception ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            ex.printStackTrace();
            // No cerramos todavía el EntityManager: queremos decidir abajo
        }

        // Ahora agendamos la cita usando una NUEVA transacción con el mismo EntityManager (no cerrado)
        try {
            em.getTransaction().begin();
            CitaManager manager = new CitaManager(em);
            Cita cita = manager.agendarCita(medico, paciente, LocalDateTime.now().plusDays(1).withHour(10), 1500.0);
            em.getTransaction().commit();
            System.out.println("Cita creada: " + cita);
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            // Cerrar al final, cuando ya no necesitás el EntityManager
            em.close();
            emf.close();
        }
    }
}
