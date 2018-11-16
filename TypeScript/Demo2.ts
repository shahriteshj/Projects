var global_num = 12;

class Employee1 {
    num_val = 13;
    static sval = 10;

    storeNum(num:number):void{
        var local_num=14;
        console.log(local_num);
    }

}

console.log("Global num " + global_num);
console.log(Employee1.sval);
var obj = new Employee1();
console.log("Global num " + obj.num_val);
