class Student {
    constructor(sId, sName, sYear, sDept) {
        this.sId = sId;
        this.sName = sName;
        this.sYear = sYear;
        this.sDept = sDept;
    }
    set studentId(sId) {
        this.sId = sId;
    }
    get studentId() {
        return this.sId;
    }
    set studentName(sName) {
        this.sName = sName;
    }
    get studentName() {
        return this.sName;
    }
    set studentYear(sYear) {
        this.sYear = sYear;
    }
    get studentYear() {
        return this.sYear;
    }
    set studentDept(sDept) {
        this.sDept = sDept;
    }
    get studentDept() {
        return this.sDept;
    }
    printStudentDetails() {
        console.log("Student Id: " + this.sId);
        console.log("Student Name: " + this.sName);
        console.log("Student Year: " + this.sYear);
        console.log("Student Id: " + this.sDept);
    }
}
let s1 = new Student(1002, "Vikash", 2, "ECE");
let s2 = new Student(1003, "Amresh", 1, "Mech");
let s3 = new Student(1001, "Uma", 3, "CSE");
let s4 = new Student(1000, "Vaishali", 4, "E&I");
let StudentList = new Set();
StudentList.add(s1);
StudentList.add(s2);
StudentList.add(s3);
StudentList.add(s4);
s1.printStudentDetails();
s2.printStudentDetails();
s3.printStudentDetails();
s4.printStudentDetails();
