package com.guanshan.phoenix.controller;

import com.guanshan.phoenix.dao.entity.Course;
import com.guanshan.phoenix.dao.entity.Module;
import com.guanshan.phoenix.dao.entity.Term;
import com.guanshan.phoenix.enums.ResourceTypeEnum;
import com.guanshan.phoenix.error.ApplicationErrorException;
import com.guanshan.phoenix.error.ResponseMessage;
import com.guanshan.phoenix.service.*;
import com.guanshan.phoenix.webdomain.*;
import com.guanshan.phoenix.webdomain.ReqUpdateTeacher;
import com.guanshan.phoenix.webdomain.ResCourseList;
import com.guanshan.phoenix.webdomain.ResSemesterList;
import com.guanshan.phoenix.webdomain.ResTeacherList;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@CrossOrigin
@RestController
@RequestMapping("admin")
public class ManagerController {

    @Autowired
    private TermService termService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private HomeworkService homeworkService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private ClassService classService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private ExperimentService experimentService;

    @Autowired
    private FileService fileService;


    @ApiOperation(value = "获取所有老师信息", notes = "")
    @GetMapping(value = "teacher/all")
    public ResponseMessage<ResTeacherList> getAllTeachers() throws ApplicationErrorException {
        return new ResponseMessage.Success<>(teacherService.getAllTeacherList());
    }

    @ApiOperation(value = "创建老师信息", notes = "")
    @PostMapping(value = "teacher/creation")
    @Transactional(rollbackFor = Throwable.class)
    public ResponseMessage createTeacher(@RequestBody ReqUpdateTeacher reqUpdateTeacher) throws ApplicationErrorException {
        teacherService.createTeacher(reqUpdateTeacher);
        return new ResponseMessage.Success();
    }

    @ApiOperation(value = "更新老师信息", notes = "")
    @PostMapping(value = "teacher/updation")
    @Transactional(rollbackFor = Throwable.class)
    public ResponseMessage updateTeacher(@RequestBody ReqUpdateTeacher reqUpdateTeacher) throws ApplicationErrorException {
        teacherService.updateTeacher(reqUpdateTeacher);
        return new ResponseMessage.Success();
    }

    @ApiOperation(value = "删除老师", notes = "")
    @PostMapping(value = "teacher/deletion")
    @Transactional(rollbackFor = Throwable.class)
    public ResponseMessage deleteTeacher(@RequestParam("teacherId") int teacherId) throws ApplicationErrorException {
        teacherService.deleteTeacherByTeacherUserId(teacherId);
        return new ResponseMessage.Success();
    }

    @ApiOperation(value = "获取所有学期信息", notes = "")
    @GetMapping(value = "semester/all")
    public ResponseMessage<ResSemesterList> getAllSemesters() throws ApplicationErrorException {
        return new ResponseMessage.Success<>(termService.getAllTerms());
    }

    @ApiOperation(value = "新增学期", notes = "")
    @PostMapping(value = "semester/creation")
    public ResponseMessage createSemester(@RequestBody Term term) throws ApplicationErrorException {
        termService.create(term);
        return new ResponseMessage.Success();
    }

    @ApiOperation(value = "更新学期", notes = "")
    @PostMapping(value = "semester/updation")
    public ResponseMessage updateSemester(@RequestBody Term term) throws ApplicationErrorException {
        termService.update(term);
        return new ResponseMessage.Success();
    }

    @ApiOperation(value = "删除学期", notes = "")
    @PostMapping(value = "semester/deletion")
    public ResponseMessage deleteSemester(@RequestParam int semesterId) throws ApplicationErrorException {
        termService.delete(semesterId);
        return new ResponseMessage.Success();
    }

    @ApiOperation(value = "删除作业", notes = "")
    @PostMapping(value = "class/homework/deletion")
    @Transactional(rollbackFor = Throwable.class)
    public ResponseMessage deleteHomework(@RequestParam("homeworkId") int homeworkId) throws ApplicationErrorException {
        homeworkService.deleteHomework(homeworkId);
        return new ResponseMessage.Success();
    }


    @ApiOperation(value = "更新作业", notes = "")
    @PostMapping(value = "class/homework/updation")
    public ResponseMessage updateHomework(@RequestBody ReqUpdateHomework reqUpdateHomework) throws ApplicationErrorException {
        homeworkService.updateHomework(reqUpdateHomework);
        return new ResponseMessage.Success();
    }

    @ApiOperation(value = "添加作业", notes = "")
    @PostMapping(value = "class/homework/creation")
    public ResponseMessage createHomework(@RequestBody ReqCreateHomework reqCreateHomework) throws ApplicationErrorException {
        homeworkService.createHomework(reqCreateHomework);
        return new ResponseMessage.Success();
    }

    @ApiOperation(value = "获取班级作业", notes = "")
    @GetMapping(value = "/class/{classId}/homework")
    public ResponseMessage<ResClassHomework> getClassHomework(@PathVariable("classId") int classId) throws ApplicationErrorException {
        return new ResponseMessage.Success<>(homeworkService.getClassHomework(classId));
    }

    @ApiOperation(value = "获取课程信息", notes = "")
    @GetMapping(value = "course/all")
    public ResponseMessage<ResCourseList> getAllCourses() throws ApplicationErrorException {
        return new ResponseMessage.Success<>(courseService.getAllCourses());
    }

    @ApiOperation(value = "创建课程信息", notes = "")
    @PostMapping(value = "course/creation")
    @Transactional(rollbackFor = Throwable.class)
    public ResponseMessage createCourse(@RequestBody ReqAddCourse reqAddCourse) throws ApplicationErrorException {
        courseService.createCourse(reqAddCourse);
        return new ResponseMessage.Success();
    }

    @ApiOperation(value = "更新课程信息", notes = "")
    @PostMapping(value = "course/updation")
    public ResponseMessage updateCourse(@RequestBody Course course) throws ApplicationErrorException {
        courseService.updateCourse(course);
        return new ResponseMessage.Success();
    }

    @ApiOperation(value = "删除课程信息", notes = "")
    @PostMapping(value = "course/deletion")
    @Transactional(rollbackFor = Throwable.class)
    public ResponseMessage deleteCourse(@RequestParam("id") int id) throws ApplicationErrorException {
        courseService.deleteCourse(id);
        return new ResponseMessage.Success();
    }

    @ApiOperation(value = "删除班级学生", notes = "删除班级里的一个学生")
    @PostMapping(value = "/class/student/deletion")
    public ResponseMessage deleteClassStudent(@RequestBody ReqDeleteClassStudent reqDeleteClassStudent) throws ApplicationErrorException {
        classService.deleteClassStudent(reqDeleteClassStudent);
        return new ResponseMessage.Success();
    }

    @ApiOperation(value = "重置密码", notes = "")
    @PostMapping(value = "/password/resetion")
    public ResponseMessage resetPassword(@RequestParam("userId") int userId) throws ApplicationErrorException {
        managerService.resetPassword(userId);
        return new ResponseMessage.Success();
    }

    @ApiOperation(value = "更新学生信息", notes = "")
    @PostMapping(value = "/class/student/updation")
    public ResponseMessage updateStudentInfo(ReqUpdateStudent reqUpdateStudent) throws ApplicationErrorException {
        studentService.updateStudentInfo(reqUpdateStudent);
        return new ResponseMessage.Success();
    }

    @ApiOperation(value = "添加班级学生", notes = "")
    @PostMapping(value = "/class/student/creation")
    public ResponseMessage addClassStudent(@RequestBody ReqAddClassStudent reqAddClassStudent) throws ApplicationErrorException {
        classService.addClassStudent(reqAddClassStudent);
        return new ResponseMessage.Success();
    }

    @ApiOperation(value = "获取班级所有学生信息", notes = "")
    @GetMapping(value = "class/{classId}/students/all")
    public ResponseMessage<ResClassStudents> getAllClassStudentInfo(@PathVariable("classId") int classId) throws ApplicationErrorException {
        return new ResponseMessage.Success<>(classService.getAllClassStudentInfo(classId));
    }

    @ApiOperation(value = "删除选课", notes = "")
    @PostMapping(value = "class/deletion")
    public ResponseMessage deleteClass(@RequestParam("classId") int classId) throws ApplicationErrorException {
        classService.deleteClass(classId);
        return new ResponseMessage.Success();
    }

    @ApiOperation(value = "更新选课信息", notes = "")
    @PostMapping(value = "class/updation")
    public ResponseMessage updateClassInfo(@RequestBody ReqUpdateClass reqUpdateClass) throws ApplicationErrorException {
        classService.updateClassInfo(reqUpdateClass);
        return new ResponseMessage.Success();
    }

    @ApiOperation(value = "新增选课", notes = "")
    @PostMapping(value = "class/creation")
    public ResponseMessage createClass(@RequestBody ReqAddClass reqAddClass) throws ApplicationErrorException {
        classService.createClass(reqAddClass);
        return new ResponseMessage.Success();
    }

    @ApiOperation(value = "获取所有班级信息", notes = "")
    @GetMapping(value = "class/all")
    public ResponseMessage<ResClassInfos> getAllClassInfo() throws ApplicationErrorException {
        return new ResponseMessage.Success<ResClassInfos>(classService.getAllClassInfo());
    }

    @ApiOperation(value = "获取课程实验信息", notes = "")
    @GetMapping(value = "course/{courseId}/experiments/")
    public ResponseMessage<ResCourseExperiments> getCourseExperiments(@PathVariable int courseId) throws ApplicationErrorException {
        return new ResponseMessage.Success<>(courseService.getCourseExperiments(courseId));
    }

    @ApiOperation(value = "新增课时", notes = "")
    @PostMapping(value = "course/module/creation")
    public ResponseMessage createModule(@RequestBody Module module) throws ApplicationErrorException {
        moduleService.createModule(module);
        return new ResponseMessage.Success();
    }

    @ApiOperation(value = "删除课时", notes = "")
    @PostMapping(value = "course/module/deletion")
    public ResponseMessage deleteModule(@RequestParam("moduleId") int moduleId) throws ApplicationErrorException {
        moduleService.deleteModule(moduleId);
        return new ResponseMessage.Success();
    }

    @ApiOperation(value = "删除实验", notes = "")
    @PostMapping(value = "/course/experiment/deletion")
    public ResponseMessage deleteExperiment(@RequestParam("id") int id) throws ApplicationErrorException {
        experimentService.deleteExperiment(id);
        return new ResponseMessage.Success();
    }

    @ApiOperation(value = "增加实验", notes = "")
    @PostMapping(value = "/course/module/experiment/creation")
    public ResponseMessage createExperiment(@RequestBody ReqExperiment reqExperiment) throws ApplicationErrorException {
        experimentService.createExperiment(reqExperiment);
        return new ResponseMessage.Success();
    }

    @ApiOperation(value = "更新实验", notes = "")
    @PostMapping(value = "/course/module/experiment/updation")
    public ResponseMessage updateExperiment(@RequestBody ReqExperiment reqExperiment) throws ApplicationErrorException {
        experimentService.updateExperiment(reqExperiment);
        return new ResponseMessage.Success();
    }

    @ApiOperation(value = "获取课时图片资源", notes = "")
    @PostMapping(value = "/admin/course/{moduleId}/lib")
    public ResponseMessage<ResModuleImages> getModuleImageUrls(@PathVariable("moduleId") int moduleId) throws ApplicationErrorException {
        return new ResponseMessage.Success<>(moduleService.getModuleImageUrls(moduleId));
    }

    @ApiOperation(value = "上传markdown文档", notes = "")
    @PostMapping(value = "/course/experiment/markdown")
    public ResponseMessage<String> uploadMarkdown(@RequestParam("file") MultipartFile file) throws ApplicationErrorException {
        return new ResponseMessage.Success<>(fileService.uploadFile(file, ResourceTypeEnum.MARKDOWN));
    }

    @ApiOperation(value = "上传图片资源", notes = "")
    @PostMapping(value = "/course/experiment/piclib")
    public ResponseMessage<String> uploadImage(@RequestParam("file") MultipartFile file) throws ApplicationErrorException {
        return new ResponseMessage.Success<>(fileService.uploadFile(file, ResourceTypeEnum.IMAGE));
    }

    @ApiOperation(value = "批量导入学生数据", notes = "")
    @PostMapping(value = "/class/student/batchCreation")
    public ResponseMessage<RepBatchAddStudent> batchStudentCreation(@RequestParam("classId") int classId, @RequestParam("file") MultipartFile file) throws ApplicationErrorException {
        return new ResponseMessage.Success<RepBatchAddStudent>(studentService.batchStudentCreation(classId, file));
    }

    @ApiOperation(value = "批量导入教师数据", notes = "")
    @PostMapping(value = "/teacher/batchCreation")
    public ResponseMessage<RepBatchAddTeacher> batchTeacherCreation(@RequestParam("file") MultipartFile file) throws ApplicationErrorException {
        return new ResponseMessage.Success<RepBatchAddTeacher>(teacherService.batchTeacherCreation(file));
    }

}


