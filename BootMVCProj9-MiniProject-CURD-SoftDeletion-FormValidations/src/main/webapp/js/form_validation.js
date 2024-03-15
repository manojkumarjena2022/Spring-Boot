function validate(frm)
{

 document.getElementById("enameErr").innerHTML="";
 document.getElementById("jobErr").innerHTML="";
 document.getElementById("deptnoErr").innerHTML="";
 document.getElementById("salErr").innerHTML="";
//read form data
let name=frm.ename.value;
let job=frm.job.value;
let deptno=frm.deptno.value;
let salary=frm.sal.value;

let validationFlag=true;


if(name=="") {
validationFlag=false;
  document.getElementById("enameErr").innerHTML="Employee name is required(cs).";
} else if(name.length<5) {
validationFlag=false;
document.getElementById("enameErr").innerHTML="Employee name must have minimum 5 characters(cs).";
}

if(job=="") {
validationFlag=false;
  document.getElementById("jobErr").innerHTML="Employee desg is required(cs).";
} else if(job.length<5) {
validationFlag=false;
document.getElementById("jobErr").innerHTML="Employee desg must have minimum 5 characters(cs).";
}

if(deptno=="") {
validationFlag=false;
  document.getElementById("deptnoErr").innerHTML="Employee dept no is required(cs).";
} else if(isNaN(deptno)) {
validationFlag=false;
document.getElementById("deptnoErr").innerHTML="Employee dept no must be numeric value(cs).";
} else if(deptno <5 || deptno >13) {
validationFlag=false;
document.getElementById("deptnoErr").innerHTML="Employee dept no must be given in range 5 and 13(cs).";
}

if(salary=="") {
validationFlag=false;
  document.getElementById("salErr").innerHTML="Employee salary is required(cs).";
} else if(isNaN(salary)) {
validationFlag=false;
document.getElementById("salErr").innerHTML="Employee salary must be numeric value(cs).";
} else if(parseFloat(salary) < 10000 || parseFloat(salary) > 100000) {
validationFlag=false;
document.getElementById("salErr").innerHTML="Employee salary must be given in range 10000 and 100000(cs).";
}
if(validationFlag)
{
frm.vflag.value="yes";
}
else
{
frm.vflag.value="no";
}

return validationFlag;
} 