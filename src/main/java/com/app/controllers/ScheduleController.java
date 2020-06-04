package com.app.controllers;

import com.app.models.AcademicPlan;
import com.app.models.SemesterPlan;
import com.app.models.Specialty;
import com.app.models.Subject;
import com.app.models.dto.AcademicPlanDto;
import com.app.models.dto.SemesterPlanDto;
import com.app.models.dto.SpecialtyDto;
import com.app.models.dto.SubjectDto;
import com.app.repository.AcademicPlanRepository;
import com.app.repository.SemesterPlanRepository;
import com.app.repository.SpecialtyRepository;
import com.app.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private AcademicPlanRepository academicPlanRepository;

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Autowired
    private SemesterPlanRepository semesterPlanRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @PostMapping("/new_academic_plan")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createNewAcademicPlan(@Valid @RequestBody AcademicPlanDto academicPlanDto) {

        try {

            academicPlanRepository.save(new AcademicPlan(academicPlanDto.getFileName(), academicPlanDto.getDateStart(), academicPlanDto.getDateEnd()));
            return ResponseEntity.ok("Учебный план успешно добавлен");
        }
        catch (Exception ex) {

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(ex.getLocalizedMessage());
        }
    }

    @GetMapping("/academic_plan/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER')")
    public ResponseEntity<?> getAcademicPlan(@PathVariable("id") Long id) {

        Optional<AcademicPlan> ap = academicPlanRepository.findById(id);

        if (ap.isPresent()) {

            return ResponseEntity.ok().body(ap.get());
        }
        else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/academic_plan_all")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER')")
    public List<AcademicPlan> getAllAcademicPlans() {

        return academicPlanRepository.findAll();
    }

    @PutMapping("/academic_plan/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateAcademicPlan(@PathVariable("id") Long id, @RequestBody AcademicPlanDto academicPlanDto) {

        Optional<AcademicPlan> oap = academicPlanRepository.findById(id);

        if (oap.isPresent()) {

            AcademicPlan ap = oap.get();

            ap.setFileName(academicPlanDto.getFileName());
            ap.setDateStart(academicPlanDto.getDateStart());
            ap.setDateEnd(academicPlanDto.getDateEnd());

            academicPlanRepository.save(ap);

            return ResponseEntity.ok().body("Учебный план обновлен");

        }
        else {

            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("delete_academic_plan/{id}")
    @PreAuthorize("harRole('ADMIN')")
    public ResponseEntity<?> deleteAcademicPlan(@PathVariable("id") Long id) {

        Optional<AcademicPlan> oap = academicPlanRepository.findById(id);

        if (oap.isPresent()) {

            academicPlanRepository.deleteById(oap.get().getId());

            return ResponseEntity.ok().body("Учебный план удален");

        }
        else {

            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/specialty")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> newSpecialty(@Valid @RequestBody SpecialtyDto specialtyDto) {

        try {

            Specialty s = new Specialty();
            s.setName(specialtyDto.getName());
            s.setCode(specialtyDto.getCode());
            Optional<AcademicPlan> oap = academicPlanRepository.findById(specialtyDto.getAcademicPlanId());

            if (oap.isPresent()) {

                s.setAcademicPlan(oap.get());

                specialtyRepository.save(s);

                return ResponseEntity.ok().body("Специальность добавлена");
            }
            else {

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Не найден учебный план");
            }
        }
        catch (Exception ex) {

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(ex.getLocalizedMessage());
        }
    }

    @GetMapping("/specialty/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER') or hasRole('STUDENT')")
    public ResponseEntity<?> getSpecialty(@PathVariable("id") Long id) {

        Optional<Specialty> os = specialtyRepository.findById(id);

        if (os.isPresent()) {

            return ResponseEntity.ok().body(os.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Специальность не найдена");
    }

    @GetMapping("/academic_plan/{id}/specialties")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER') or hasRole('STUDENT')")
    public List<Specialty> getAcademicPlanSpecialties(@PathVariable("id") Long id) {

        Optional<AcademicPlan> ap = academicPlanRepository.findById(id);

        List<Specialty> empty = new ArrayList<>();

        return ap.map(academicPlan -> specialtyRepository.findByAcademicPlan(academicPlan)).orElse(empty);

    }


    @DeleteMapping("/specialty/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteSpecialty(@PathVariable("id") Long id) {

        Optional<Specialty> os = specialtyRepository.findById(id);

        if (os.isPresent()) {

            specialtyRepository.deleteById(id);

            return ResponseEntity.ok().body("Специальность удалена");

        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/specialty/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateSpecialty(@PathVariable("id") Long id, @Valid @RequestBody SpecialtyDto specialtyDto) {

        Optional<Specialty> os = specialtyRepository.findById(id);

        if (os.isPresent()) {

            Specialty s = os.get();

            s.setName(specialtyDto.getName());
            s.setCode(specialtyDto.getCode());

            Optional<AcademicPlan> oap = academicPlanRepository.findById(specialtyDto.getAcademicPlanId());

            if (oap.isPresent()) {

                s.setAcademicPlan(oap.get());

                specialtyRepository.save(s);

                return ResponseEntity.ok().body("Специальность обновлена");
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Не найден учебный план");
        }

        return ResponseEntity.notFound().build();
    }


    @PostMapping("/semester_plan")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> newSemesterPlan(@Valid @RequestBody SemesterPlanDto semesterPlanDto) {

        try {

            SemesterPlan sp = new SemesterPlan();

            Optional<Specialty> os = specialtyRepository.findById(semesterPlanDto.getSpecialtyId());

            if (os.isPresent()) {

                sp.setSpecialty(os.get());

                if (semesterPlanDto.getSemesterNumber() >= 1 || semesterPlanDto.getSemesterNumber() <= 5) {

                    sp.setSemesterNumber(semesterPlanDto.getSemesterNumber());

                    sp.setFileName(semesterPlanDto.getFileName());

                    semesterPlanRepository.save(sp);

                    return ResponseEntity.ok().body("Семестровый план сохранен");
                }

                return ResponseEntity.badRequest().body("Номер семестра должен быть в диапазоне от 1 до 5");
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Специальность не найдена");

        }
        catch (Exception ex) {

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(ex.getLocalizedMessage());
        }
    }

    @PutMapping("/semester_plan/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateSemesterPlan(@PathVariable("id") Long id, @Valid @RequestBody SemesterPlanDto semesterPlanDto) {

        Optional<SemesterPlan> osp = semesterPlanRepository.findById(id);

        if (osp.isPresent()) {

            SemesterPlan sp = osp.get();

            Optional<Specialty> os = specialtyRepository.findById(semesterPlanDto.getSpecialtyId());

            if (os.isPresent()) {

                sp.setSpecialty(os.get());

                if (semesterPlanDto.getSemesterNumber() >= 1 || semesterPlanDto.getSemesterNumber() <= 5) {

                    sp.setSemesterNumber(semesterPlanDto.getSemesterNumber());

                    sp.setFileName(semesterPlanDto.getFileName());

                    semesterPlanRepository.save(sp);

                    return ResponseEntity.ok().body("Семестровый план обновлен");
                }

                return ResponseEntity.badRequest().body("Номер семестра должен быть в диапазоне от 1 до 5");
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Специальность не найдена");
        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping("/specialty/{id}/semester_plans")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER') or hasRole('STUDENT')")
    public List<SemesterPlan> getSemesterPlansBySpecialty(@PathVariable("id") Long id) {

        List<SemesterPlan> empty = new ArrayList<>();

        Optional<Specialty> os = specialtyRepository.findById(id);

        return os.map(specialty -> semesterPlanRepository.findBySpecialty(specialty)).orElse(empty);
    }

    @GetMapping("/semester_plan/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER') or hasRole('STUDENT')")
    public ResponseEntity<?> getSemesterPlan(@PathVariable("id") Long id) {

        Optional<SemesterPlan> osp = semesterPlanRepository.findById(id);

        if (osp.isPresent()) {

            return ResponseEntity.ok().body(osp.get());
        }

        return ResponseEntity.notFound().build();
    }


    @PostMapping("/subject")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> newSubject(@Valid @RequestBody SubjectDto subjectDto) {

        Optional<SemesterPlan> osp = semesterPlanRepository.findById(subjectDto.getSemesterPlanId());

        if (osp.isPresent()) {

            Subject s = new Subject();
            s.setSemesterPlan(osp.get());
            s.setName(subjectDto.getName());
            s.setShortName(subjectDto.getShortName());
            s.setFileName(subjectDto.getFileName());

            try {

                subjectRepository.save(s);

                return ResponseEntity.ok().body("Дисциплина создана");
            }
            catch (Exception ex) {

                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(ex.getLocalizedMessage());
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Семестровый план не найден");
    }

    @PutMapping("/subject/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateSubject(@PathVariable("id") Long id, @Valid @RequestBody SubjectDto subjectDto) {

        Optional<SemesterPlan> osp = semesterPlanRepository.findById(subjectDto.getSemesterPlanId());

        if (osp.isPresent()) {

            Optional<Subject> os = subjectRepository.findById(subjectDto.getId());

            if (!os.isPresent()) {

                return ResponseEntity.notFound().build();
            }

            Subject s = os.get();
            s.setSemesterPlan(osp.get());
            s.setName(subjectDto.getName());
            s.setShortName(subjectDto.getShortName());
            s.setFileName(subjectDto.getFileName());

            try {

                subjectRepository.save(s);

                return ResponseEntity.ok().body("Дисциплина обновлена");
            }
            catch (Exception ex) {

                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(ex.getLocalizedMessage());
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Семестровый план не найден");
    }

    @GetMapping("/semester_plane/{id}/subjects")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER') or hasRole('STUDENT')")
    public List<Subject> getSubjectsBySemesterPlan(@PathVariable("id") Long id) {

        List<Subject> empty = new ArrayList<>();

        Optional<SemesterPlan> osp = semesterPlanRepository.findById(id);

        if (osp.isPresent()) {

            return subjectRepository.findBySemesterPlan(osp.get());
        }

        return empty;
    }

    @GetMapping("/subject/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER') or hasRole('STUDENT')")
    public ResponseEntity<?> getSubject(@PathVariable("id") Long id) {

        Optional<Subject> os = subjectRepository.findById(id);

        if (os.isPresent()) {

            return ResponseEntity.ok().body(os.get());
        }

        return ResponseEntity.notFound().build();
    }

    //TODO: контроллеры для должности, аудитории, взвода и занятия
    //TODO: в отдельный класс контроллер студентов и преподов
    //TODO: сделать все поля-множества в Entity @JsonIgnore




}
