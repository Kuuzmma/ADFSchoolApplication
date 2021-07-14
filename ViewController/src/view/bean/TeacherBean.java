package view.bean;

import oracle.adf.view.rich.event.DialogEvent;

import view.common.MyADFUtil;

public class TeacherBean {
    public TeacherBean() {
    }

    public void deleteTeacherDialogListener(DialogEvent dialogEvent) 
    {
        MyADFUtil.executeOperation("Delete");
        MyADFUtil.executeOperation("Commit");
        MyADFUtil.showSuccessfulMessage("Teacher deleted successfully.");
    }
}
