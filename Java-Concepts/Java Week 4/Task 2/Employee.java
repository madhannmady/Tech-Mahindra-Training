class Employee {
    int empId;
    String empName;
    double sal;
    int yearsWorked;

    public Employee(int empId, String empName, double sal, int yearsWorked) {
        this.empId = empId;
        this.empName = empName;
        this.sal = sal;
        this.yearsWorked = yearsWorked;
    }

    public void getEmployeeDetails() {
        System.out.println("ID: " + empId + ", Name: " + empName + ", Salary: " + sal + ", Years Worked: " + yearsWorked);
    }

    public void setEmployeeDetails(int empId, String empName, double sal, int yearsWorked) {
        this.empId = empId;
        this.empName = empName;
        this.sal = sal;
        this.yearsWorked = yearsWorked;
    }

    public void getLoanEligibility() {
        if (yearsWorked > 5) {
            if (sal >= 1500000) {
                System.out.println("Eligible for 7 lakhs loan");
            } else if (sal >= 1000000) {
                System.out.println("Eligible for 5 lakhs loan");
            } else if (sal >= 600000) {
                System.out.println("Eligible for 2 lakhs loan");
            } else {
                System.out.println("Not eligible for loan");
            }
        } else {
            System.out.println("Not eligible for loan");
        }
    }
}
