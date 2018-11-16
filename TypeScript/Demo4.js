var Employee = /** @class */ (function () {
    function Employee(newName) {
        this.fullName1 = newName;
    }
    Object.defineProperty(Employee.prototype, "fullName", {
        get: function () {
            return this.fullName1;
        },
        set: function (newName) {
            this.fullName1 = newName;
        },
        enumerable: true,
        configurable: true
    });
    return Employee;
}());
var employee = new Employee("ABCD");
//employee.fullName = "Bob Smith";
console.log(employee.fullName);
