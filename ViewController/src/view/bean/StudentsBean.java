package view.bean;

import oracle.adf.view.rich.event.DialogEvent;

import view.common.MyADFUtil;

public class StudentsBean {
    public StudentsBean() {
    }

    public void deleteStudentDialogListener(DialogEvent dialogEvent)
    {
        MyADFUtil.executeOperation("Delete");
        MyADFUtil.executeOperation("Commit");
        MyADFUtil.showSuccessfulMessage("Student deleted successfully.");
    }
}
