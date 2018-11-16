var global_num = 12;
function storeNum1(num) {
    var local_num = 14;
    console.log(local_num);
}
var Employee = /** @class */ (function () {
    function Employee() {
        this.num_val = 13;
    }
    Employee.prototype.storeNum = function (num) {
        var local_num = 14;
        console.log(local_num);
    };
    Employee.sval = 10;
    return Employee;
}());
console.log("Global num " + global_num);
console.log(Employee.sval);
var obj = new Employee();
console.log("Global num " + obj.num_val);
console.log(storeNum1());
