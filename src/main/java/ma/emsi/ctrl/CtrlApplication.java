package ma.emsi.ctrl;

import ma.emsi.ctrl.dao.PatientRepository;
import ma.emsi.ctrl.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class CtrlApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(CtrlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        patientRepository.save(new Patient(null, "Oumaima", new Date(), 2300, false));
        patientRepository.save(new Patient(null, "Houda", new Date(), 2760, false));
        patientRepository.save(new Patient(null, "Lahsen", new Date(), 3000, true));
        patientRepository.save(new Patient(null, "Aymane", new Date(), 4356, false));
        patientRepository.save(new Patient(null, "Khadija", new Date(), 7658, true));
        patientRepository.save(new Patient(null, "Hiba", new Date(), 9357, true));
        patientRepository.save(new Patient(null, "Mounia", new Date(), 2356, false));
        patientRepository.save(new Patient(null, "Asmaa", new Date(), 2300, false));
        patientRepository.save(new Patient(null, "Omar", new Date(), 2760, false));
        patientRepository.save(new Patient(null, "Hafsa", new Date(), 3000, true));
        patientRepository.save(new Patient(null, "Samira", new Date(), 4356, false));
        patientRepository.save(new Patient(null, "Yassine", new Date(), 7658, true));
        patientRepository.save(new Patient(null, "Soufiane", new Date(), 9357, true));
        patientRepository.save(new Patient(null, "Mohammed", new Date(), 2356, false));
        patientRepository.save(new Patient(null, "Said", new Date(), 2300, false));
        patientRepository.save(new Patient(null, "Jihane", new Date(), 2760, false));
        patientRepository.save(new Patient(null, "Kamal", new Date(), 3000, true));
        patientRepository.save(new Patient(null, "Samir", new Date(), 4356, false));
        patientRepository.save(new Patient(null, "AbdRahman", new Date(), 7658, true));
        patientRepository.save(new Patient(null, "Achraf", new Date(), 9357, true));
        patientRepository.save(new Patient(null, "Serkan", new Date(), 2356, false));
        patientRepository.save(new Patient(null, "Serkan", new Date(), 2356, false));
        patientRepository.save(new Patient(null, "Serkan", new Date(), 2356, false));
        patientRepository.save(new Patient(null, "Serkan", new Date(), 2356, false));
        patientRepository.save(new Patient(null, "Serkan", new Date(), 2356, false));
        patientRepository.save(new Patient(null, "Serkan", new Date(), 2356, false));
        patientRepository.save(new Patient(null, "Serkan", new Date(), 2356, false));
        patientRepository.save(new Patient(null, "Serkan", new Date(), 2356, false));

        patientRepository.findAll().forEach(p -> {
            System.out.println(p.getName());
        });
    }
}
