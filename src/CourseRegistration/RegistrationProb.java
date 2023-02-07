package CourseRegistration;


class CourseRegistration {

    String studentName;
    int registrationId;
    float qualifyingMarks;
    double courseFee;
    int courseId;
    boolean hostelRequired;
    

    public CourseRegistration(String studentName, int registrationId, float qualifyingMarks, 
			int courseId, boolean hostelRequired) {
		this.studentName = studentName;
		this.registrationId = registrationId;
		this.qualifyingMarks = qualifyingMarks;
		
		this.courseId = courseId;
		this.hostelRequired = hostelRequired;
	}

	public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public float getQualifyingMarks() {
        return qualifyingMarks;
    }

    public void setQualifyingMarks(float qualifyingMarks) {
        this.qualifyingMarks = qualifyingMarks;
    }

    public double getCourseFee() {
        return courseFee;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public boolean isHostelRequired() {
        return hostelRequired;
    }

    public void setHostelRequired(boolean hostelRequired) {
        this.hostelRequired = hostelRequired;
    }

    public boolean validateMarks(){

        if (getQualifyingMarks() >= 65 && getQualifyingMarks() <= 100)
            return true;

        else
            return false;
    }

    public boolean validateCourseId(){

        if (getCourseId() >= 1001 && getCourseId() <= 1005)
            return true;
        else
            return false;
    }

    public void calculateCourseFee(){

      if (validateMarks()) {
          if (validateCourseId()) {

              double totalFees = 0;

              if (getCourseId() == 1001)
                  courseFee = 55000;

              else if (getCourseId() == 1002)
                  courseFee = 35675;

              else if (getCourseId() == 1003)
                  courseFee = 28300;

              else if (getCourseId() == 1004)
                  courseFee = 22350;

              else
                  courseFee = 115000;

              double discount = 0;

              if (getQualifyingMarks() >= 85) {
                  discount = 0.15;
              } else if (getQualifyingMarks() >= 70) {
                  discount = 0.10;
              } else if (getQualifyingMarks() >= 65) {
                  discount = 0.05;
              }

              totalFees = courseFee - (courseFee * discount);

              System.out.println("Total course fees : " + totalFees);
          } else {
              System.out.println("Invalid Course Id. Please try again");
          }
      }else {
          System.out.println("Marks is less than 65. You are not eligible for admission!!");
      }
    }
}
public class RegistrationProb{

	public static void main(String args[]) {
		CourseRegistration Course1=new CourseRegistration("Peter",5001,58,1005,true);
		CourseRegistration Course2=new CourseRegistration("Peter",5001,68,1006,true);
		CourseRegistration Course3=new CourseRegistration("Peter",5001,78,1005,false);
		Course1.validateCourseId();
		Course1.validateMarks();
		Course1.calculateCourseFee();
		Course2.validateCourseId();
		Course2.validateMarks();
		Course2.calculateCourseFee();
		Course3.validateCourseId();
		Course3.validateMarks();
		Course3.calculateCourseFee();
		
		
	}
}