package ma.emsi.ctrl.web;


import ma.emsi.ctrl.dao.PatientRepository;
import ma.emsi.ctrl.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping(path = "/index")
    public String index() {
        return "index";
    }


    @GetMapping(path = "/patients")
    public String list(Model model,
                       @RequestParam(name = "page", defaultValue = "0") int page,
                       @RequestParam(name = "size", defaultValue = "5") int size,
                       @RequestParam(name = "keyword", defaultValue = "") String kw) {
        Page<Patient> pagePatients = patientRepository.findByNameContains(kw, PageRequest.of(page, size));
        model.addAttribute("patients", pagePatients.getContent());
        model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", kw);
        return "patients";
    }
    @GetMapping(path = "/editPatient")
    public String edit(Model model, Long id) {
        Patient p= patientRepository.findById(id).get();
        model.addAttribute("patient", p);
        return "formPatient";
    }
    @GetMapping(path = "/deletePatient")
    public String delete(Long id) {
        patientRepository.deleteById(id);
        return "redirect:/patients";
    }
    @GetMapping(path = "/home")
    public String home(Long id) {
        return "home";
    }
    @GetMapping(path = "/formPatient")
    public String formPatient(Model model) {
        model.addAttribute("patient",new Patient());
        return "formPatient";
    }
    @PostMapping(path = "/savePatient")
    public String savePatient(Model model, Patient patient) {
        patientRepository.save(patient);
        model.addAttribute("patient", patient);
        return "confirmation";
    }

    @GetMapping("/listPatients")
    @ResponseBody
    public List<Patient> list(){
        return patientRepository.findAll();
    }

}
