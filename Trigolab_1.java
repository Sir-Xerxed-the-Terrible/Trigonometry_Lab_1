/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trigolab_1;
     import java.util.Scanner;
import static java.lang.Math.*;


import java.util.Scanner;


/**
 *
 * @author Student
 */
public class Trigolab_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        
        do{
            System.out.println("\n=== Trigonometry Lab by Your truly ===");
            System.out.println("1. Problem Number 1");
            System.out.println("2. Problem Number 2");
            System.out.println("3. Problem Number 3");
            System.out.println("4. Problem Number 4");
            System.out.println("5. Problem Number 5");
            System.out.println("0. Stop");
            System.out.println("Input a number to choose its respective problem");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1: Problemnumber1(sc); break;
                case 2: Problemnumber2(sc); break;
                case 3: Problemnumber3(sc); break;
                case 4: Problemnumber4(sc); break;
                case 5: Problemnumber5(sc); break;
                case 0: System.out.println("Bye! Bye!"); break;
                default: System.out.println("Invalid Choice.");
            }
                
                
          } while (choice !=0);
        
          sc.close();
                  
         }         

    static void Problemnumber1 (Scanner sc) {
        System.out.println("Enter angle in Degrees: ");
        double deg= sc.nextDouble();
        double rad= toRadians(deg);
        
        System.out.println("Choose a Function");
        System.out.println("1. Sine 2. Cosine 3. Tangent 4. All");
        int ch= sc.nextInt();
        
        if (ch == 1 || ch == 4)
            System.out.printf("sin(%.2f deg) = %.4f%n",deg, sin(rad));
        if (ch == 2 || ch == 4)
            System.out.printf("cos(%.2f deg) = %.4f%n",deg, cos(rad));
        if (ch == 3 || ch == 4){
            if (abs(cos(rad)) < 1e-10)
            System.out.println("tan unidentified at this angle.");
            else
            System.out.printf("tan(%.2f deg) = %.4f%n",deg, tan(rad));}
            
    }
    //Critical Thinking Question
    //Why do we need to convert angles from degrees to radians?
    //Answer: To hasten the translation between systems and human input as -
    //-machines generally uses radians for its function while human generally -
    //-uses degress as it is much simple.
    //what makes tangent unidentfied in certain angles?
    //Answer: tagnent in its trigonometric identity is seen as a fraction and -
    //-a fraction with zero denominator(in this case cosine) is renedered to be -
    //-undetermined.
    //How would you modify  this program to calculate reciprocal functions?
    //Answer: by changing ceratin lines that print the functions such as line -
    //- number 23 to produce arc sin and such.
   
       

     static void Problemnumber2 (Scanner sc) {
         System.out.println("Enter angle in Degrees: ");
         double deg = sc.nextDouble();
         double norm = ((deg % 360) % 360);
         
         if (norm == 0 || norm == 180) {
             System.out.println("Angle on x-axis -> sin=0, cos==/-1, tan=0");}
         else if (norm == 90 || norm == 270) {
             System.out.println("Angle on y-axis -> cos=0, sin=/-1, tan2"
                     + "=unidentified");}
         else if (norm > 0 & norm < 90) {
             System.out.println("Quadrant I -> sin=+, cos==+, tan=+ ");}
         else if (norm > 90 & norm < 180) {
             System.out.println("Quadrant II -> sin=+, cos=-, tan=-");}
         else if (norm > 180 & norm < 270) {
             System.out.println("Quadrant III -> sin=-, cos=-, tan=+");}
         else if (norm > 270 & norm < 360) {
             System.out.println("Quadrant IV -> sin=-, cos=+, tan=-");

     }
     //Critical Thinking Question
     //Why is it so important to normalize angles before determining their -
     //-quadrant?
     //Answer: So that we can determine their quadrant consistently and -
     //-efficiently.
     //How does the sign of trigonometric function change across different -
     //-quadrants?
     //Answer: to follow the AllStudentTakeCalculus Rule or ASTC Rule for short.
     //What special considerations are needed for angles exactly on the axes?
     //Answer: to determined its exact location of the point presented by the -
     //- axes.
    
}
     static void Problemnumber3 (Scanner sc) {
         System.out.println("Choose known elements");
         System.out.println("1. two sides");
         System.out.println("2. one side and one angle");
         int Type = sc.nextInt();

     double a=0, b=0, c=0, A=0,B=0, C=90;
    
     if (Type == 1) {
      System.out.println("Enter side a: "); a = sc.nextDouble();
      System.out.println("Enter side b: "); b = sc.nextDouble();
      c = sqrt(a*a + b*b);

      A = toDegrees(atan2(a,b));
      B = 90 - A;
   }else {
      System.out.println("Enter side a: "); a = sc.nextDouble();
      System.out.println("Enter angle A (<90): "); A = sc.nextDouble();
      double radA = toRadians(A);
      c = a/ sin(radA);
      b = c * cos(radA);
      B = 90 - A;
}
     double area = 0.5 * a* b;
     System.out.println("Sides; a=" + a + ", b=" + b + ", c=" + c);
     System.out.println("Angle: A=" + A + "°, B=" + B + "°, C=" + C);
     System.out.println("Area: " + area);

}
    //Why must we validate that angles in a right triangle are less than 90°?
    //Answer: a right triangle already has one 90° angle with a total of 180°
    //thus we must make sure that all side will total to 180°.
    //How does your program handle the different cases of known values?
    //Answer: by using if-else statements.
    //What would happen if a user entered values that don't form a valid right triangle?
    //Answer: the program would not function as intended.
    static void Problemnumber4 (Scanner sc) {
         System.out.println("Enter angle in degrees: ");
         double angle = sc.nextDouble();
         double rad = toRadians(angle);

     double s = sin(rad), c= cos(rad), t = tan(rad);

     double lhs1 = s*s + c*c, rhs1 = 1;
     System.out.println("sin²+cos² vs 1: " + lhs1 + "?" + rhs1);
    
    if (abs(c) > 1e-10) {
         double lhs2 = 1 + t*t, rhs2 = 1/(c*c);
         System.out.println("1+tan² vs sec²: " + lhs2 + "?" + rhs2);}   
     else {
         System.out.println("Identity 2 invalid (cos=0).");
}
    //Why do we need a tolerance when comparing floating-point values?
    //Answer: for float values are imprecise.
    //Which identity might be most susceptible to floating-point precision issues and why?
    //Answer: Decimals.
    //How could you extend this program to verify more complex identities?
    //Answer: by adding more if-else statements that fit the program.
}
     static void Problemnumber5 (Scanner sc) {
         System.out.println("Enter amplitude: "); double A = sc.nextDouble();
         System.out.println("Enter frequency: "); double f = sc.nextDouble();
         System.out.println("Enter phase shift (degrees): "); double ps = sc.nextDouble();
         System.out.println("Enter time: "); double t = sc.nextDouble();

         double radps = toRadians(ps);
         double value = A * sin(2*PI*f*t + radps);

         System.out.println("Wave value at t=" + t + "is" + value);
    
          if (abs(value - A) < 1e-6) System.out.println("at a peak.");
          else if (abs(value + A) < 1e-6) System.out.println("at a through");
         else if (abs(value) < 1e-6) System.out.println("at a zero crossing.");
         else System.out.println("In between.");

         double nextpeakT = (PI/2 - radps)/(2*PI*f);
         if (nextpeakT < t) nextpeakT += 1.0/f;
         System.out.println("Next peak at t ≈ " + nextpeakT);
}


        //How did you determine if the wave is at a peak or trough?
        //Answer: By the value inputted by the user.
        //What mathematical approach did you use to find the next peak?
        //Answer: Angular Frequency.
        //How would you modify this program to handle non-sinusoidal waves?
        //
    }
    

