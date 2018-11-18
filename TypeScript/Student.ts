class Student{
    private sId:number;
    private sName:string;
    private sYear:number;
    private sDept:string;

    constructor(sId:number,sName:string,sYear:number,sDept:string){
        this.sId=sId;
        this.sName=sName;
        this.sYear=sYear;
        this.sDept = sDept;
    }

    set studentId(sId:number){
        this.sId=sId;
    }

    get studentId():number{
        return this.sId;
    }

    set studentName(sName:string){
        this.sName=sName;
    }

    get studentName():string{
        return this.sName;
    }

    set studentYear(sYear:number){
        this.sYear=sYear;
    }

    get studentYear():number{
        return this.sYear;
    }

    set studentDept(sDept:string){
        this.sDept=sDept;
    }

    get studentDept():string{
        return this.sDept;
    }

    printStudentDetails():void{
        console.log("Student Id: " + this.sId);
        console.log("Student Name: " + this.sName);
        console.log("Student Year: " + this.sYear);
        console.log("Student Id: " + this.sDept);
    }
}

let s1 = new Student(1002,"Vikash",2,"ECE");
let s2 = new Student(1003,"Amresh",1,"Mech");
let s3 = new Student(1001,"Uma",3,"CSE");
let s4 = new Student(1000,"Vaishali",4,"E&I");
let StudentList = new Set();
StudentList.add(s1);
StudentList.add(s2);
StudentList.add(s3);
StudentList.add(s4);

s1.printStudentDetails();
s2.printStudentDetails();
s3.printStudentDetails();
s4.printStudentDetails();


