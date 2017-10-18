package com.guanshan.phoenix.webdomain;

import java.util.List;

public class ResCourseHomeworks {
    private String courseName;

    private List<ModuleInfo> moduleList;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<ModuleInfo> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<ModuleInfo> moduleList) {
        this.moduleList = moduleList;
    }

    public static class ModuleInfo {

        private int moduleId;

        private String moduleName;

        private List<HomeworkInfo> moduleContent;

        public int getModuleId() {
            return moduleId;
        }

        public void setModuleId(int moduleId) {
            this.moduleId = moduleId;
        }

        public String getModuleName() {
            return moduleName;
        }

        public void setModuleName(String moduleName) {
            this.moduleName = moduleName;
        }

        public List<HomeworkInfo> getModuleContent() {
            return moduleContent;
        }

        public void setModuleContent(List<HomeworkInfo> moduleContent) {
            this.moduleContent = moduleContent;
        }
    }

    public static class HomeworkInfo{
        private int id;

        private String homeworkName;

        private String homeworkDes;

        private String cloudwareType;

        private String dueDate;

        private String publishDate;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getHomeworkName() {
            return homeworkName;
        }

        public void setHomeworkName(String homeworkName) {
            this.homeworkName = homeworkName;
        }

        public String getHomeworkDes() {
            return homeworkDes;
        }

        public void setHomeworkDes(String homeworkDes) {
            this.homeworkDes = homeworkDes;
        }

        public String getCloudwareType() {
            return cloudwareType;
        }

        public void setCloudwareType(String cloudwareType) {
            this.cloudwareType = cloudwareType;
        }

        public String getDueDate() {
            return dueDate;
        }

        public void setDueDate(String dueDate) {
            this.dueDate = dueDate;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
        }
    }
}
