class Employee {
    private fullName1: string;

    constructor(newName: string) {
        this.fullName1 = newName;
    }

    get fullName(): string {
        return this.fullName1;
    }

    set fullName(newName: string) {
        this.fullName1 = newName;
    }
}

let employee = new Employee("ABCD");
//employee.fullName = "Bob Smith";
console.log(employee.fullName);
