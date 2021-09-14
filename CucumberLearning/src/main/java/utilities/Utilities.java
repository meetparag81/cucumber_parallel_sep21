package utilities;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import io.cucumber.java.it.Date;

public class Utilities {
    

    static RestAPIMethods restapi = new RestAPIMethods();
    static Random r = new Random();
    private static Random random = new Random();

    public static String getTodaysDate(String format)
    {
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    	LocalDateTime now = LocalDateTime.now();
        return now.toString();
    }


    public static String GenerateSSN()
    {
        Random random = new Random();
        int iThree = 0;
        do
        {
          iThree = random.nextInt(101);
        }
        while (iThree == 666);
        int iTwo = random.nextInt(11);
        int iFour = random.nextInt(1001);
        return iThree + "-" + iTwo.ToString() + "-" + iFour.ToString();
    }

    public static String generateRandomDate(int format)
    {
        Random random = new Random();
        int randomNumber =random.nextInt();
        		
         LocalDateTime todaysDate = LocalDateTime.now();
        todaysDate = todaysDate.plusDays(randomNumber);
        return todaysDate.toString();
    }

    public static String generateDate(int days, String dateType , String format , LocalDateTime date)
    {
         LocalDateTime datetoConvert = LocalDateTime.now() ;
        int numberOfDays = days;

        if (date.equals(""))
        {
            datetoConvert = LocalDateTime.now();
        }
        else
        {
            //datetoConvert = DateTime.ParseExact(date, @"dd/MM/yyyy", System.Globalization.CultureInfo.InvariantCulture);
            datetoConvert = date;
        }
        
        if (dateType.Equals("past", StringComparison.OrdinalIgnoreCase))
        {
            datetoConvert = datetoConvert.plusDays(-numberOfDays);
        }
        else if (dateType.before.Equals("future", StringComparison.OrdinalIgnoreCase))
        {
            datetoConvert = datetoConvert.plusDays(days);
        }
        else if (dateType.Equals("current", StringComparison.OrdinalIgnoreCase) || dateType.equals(""))
        {
            datetoConvert = LocalDateTime.now();
        }
        return datetoConvert.toString();
    }

    public static String generateDate(int days, String dateType , String format , String date)
    {
         LocalDateTime datetoConvert = LocalDateTime.now();
        int numberOfDays = days;

        if (date.Equals(""))
        {
            datetoConvert = LocalDateTime.now();
        }
        else
        {
            //datetoConvert = DateTime.ParseExact(date, @"dd/MM/yyyy", System.Globalization.CultureInfo.InvariantCulture);
             newdate = Convert.ToDateTime(date);
            datetoConvert = newdate;
        }
        
        if (dateType.Equals("past", StringComparison.OrdinalIgnoreCase))
        {
            datetoConvert = datetoConvert.AddDays(-numberOfDays);
        }
        else if (dateType.Equals("future", StringComparison.OrdinalIgnoreCase))
        {
            datetoConvert = datetoConvert.AddDays(days);
        }
        else if (dateType.Equals("current", StringComparison.OrdinalIgnoreCase) || dateType.Equals(""))
        {
            datetoConvert = DateTime.Today;
        }
        return datetoConvert.ToString(format);
    }

    public static int generateRandomNumberGivenRange(int minval,int maxval)
    {
        Random random = new Random();
        int randomNumber = random.nextInt((minval- maxval)+1);
        return randomNumber;
    }

    public static String generateRandomDOB(String format , int minyears ,int maxyears)
    {
    	int dob = minyears + (int)Math.round(Math.random() * (maxyears - minyears));
        Random random = new Random();
        int randomNumber = random.nextInt(minyears- maxyears);
         LocalDateTime todaysDate = LocalDateTime.now();
        todaysDate = todaysDate.minusYears(-randomNumber);
        String TodaysDate= todaysDate.toString();
        return TodaysDate;
    }

    public static String GenerateRandomString(int length)
    {
    	 String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder str_build = new StringBuilder();
        char letter;
        for (int i = 0; i < length; i++)
        {
            double flt = random.NextDouble();
            int shift = Convert.ToInt32(Math.Floor(25 * flt));
            letter = Convert.ToChar(shift + 65);
            str_build.Append(letter);
        }
        return str_build.ToString();
    }

    public static String GenerateRandomNumber(int length)
    {String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    StringBuilder salt = new StringBuilder();
    Random rnd = new Random();
    
    while (salt.length() < length) { // length of the random string.
        int index = (int) (rnd.nextFloat() * SALTCHARS.length());
        salt.append(SALTCHARS.charAt(index));
    }
    String saltStr = salt.toString();
    return saltStr;
}

    public static String GenerateRandomManager(String compCode)
    {
        Random random = new Random();
        if (compCode == "1075")
        {
            var manager = new List<string>{
        "103289","129203","25059","263403","354674","1000019","1000156","100072","1000759","1001559","1002073","1002078","1002178","104854","1151332","1176069","1178666"};
            return manager[random.Next(0, manager.Count)];
        }
        else if (compCode == "1190" || compCode == "1098")
        {
            var manager = new List<string>{
        "313210","309168","292774","289299","279094","270750","231180","225865","196934","181589","120104","113127","91944","83653","62562","53464","50951","46997","19680","4725","113127","331218","317500","315972","315930","293943","258888","245757","241790","219336","207379","200673","188466","165862","157596","101617","79395","67479","35982","13904","101617","101085","1005291","1005164","1002781"};
            return manager[random.Next(0, manager.Count)];
        }

        return null;
    }

    public static string GenerateRandCanadaPostal()
    {
        Random random = new Random();
        var manager = new List<string>{
        "M4C 1T1","M4C 1S9","M4C 1S8","M4C 1S7","M4C 1S6","M4C 1S5","M4C 1S4","M3C 0E3","M3C 0C3",
        "M4C 1S3","M4C 1S2","M4C 1S1","M4C 1R3","M4C 1R2","M4C 1R1","M4C 1P9","M4C 1P8","M3C 0C2",
        "M4C 1P7","M4C 1P6","M4C 1P5","M4C 1P4","M4C 1P3","M4C 1P1","M4C 1N9","M3C 0H9","M3C 0E4",
        "M4C 1N8","M4C 1N7","M4C 1N6","M4C 1N5","M4C 1N4","M4C 1N3","M4C 1M8","M4C 1M5","M1R 0E9",
        "M4C 1M4","M4C 1M3","M4C 1M2","M4C 1M1","M4C 1L9","M4C 1L8","M4C 1L7","M4C 1L6","M3C 0C1",
        "M4C 1L5","M4C 1L4","M4C 1L3","M4C 1L2","M4C 1L1","M4C 1K9","M4C 1K8","M4C 1K7","M3C 0J1",
        "M4C 1K5","M4C 1K4","M4C 1K3","M4C 1K2","M4C 1K1","M4C 1J9","M4C 1J8","M4C 1J7","M4C 1J6",
        "M4C 1J5","M4C 1J4","M4C 1J3","M4C 1J2","M4C 1J1","M4C 1H9","M4C 1H8","M4C 1H7","M4C 1H6",
        "M4C 1H5","M4C 1H4","M4C 1H3","M4C 1H2","M4C 1H1","M4C 1G9","M4C 1G8","M4C 1G7","M4C 1G6",
        "M4C 1G5","M4C 1G4","M4C 1G2","M4C 1G1","M4C 1E9","M4C 1E8","M4C 1E7","M4C 1E6","M4C 1E5",
        "M4C 1E4","M4C 1E3","M4C 1E2","M4C 1E1","M4C 1C9","M4C 1C8","M4C 1C7","M4C 1C6","M4C 1C5",
        "M4C 1C4","M4C 1C3","M4C 1C2","M4C 1C1","M4C 1B9","M4C 1B8","M4C 1B7","M4C 1B6","M4C 1B5",
        "M4C 1B4","M4C 1B3","M4C 1B2","M4C 1B1","M4C 1A9","M4C 1A8","M4C 1A7","M4C 1A6","M4C 1A5",
        "M4C 1A4","M4C 1A3","M4C 1A1","M4C 0A9","M4C 0A3","M4C 0A2","M4C 0A1","M4B 3E9","M4B 3E5",
        "M4B 2J8","M4B 0A3","M3M 3G1","M3M 0A9","M3H 6A7","M3H 0C3","M3C 0N6","M3C 0L8"};
        return manager[random.Next(0, manager.Count)];
    }

    /*public static Date generateRandomDate(Date StartRange, String dateType)
    {GregorianCalendar gc = new GregorianCalendar();

    int year = randBetween(1900, 2010);

    gc.set(gc.YEAR, year);

    int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

    gc.set(gc.DAY_OF_YEAR, dayOfYear);

    System.out.println(gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH));

}
*/
public static int generateRandomDate(int start, int end) {
    return start + (int)Math.round(Math.random() * (end - start));
}

    public static Date convertStringtoDateFormat(String date)
    {
        DateTime datetoConvert = Date.ParseExact(date, @"dd/MM/yyyy", System.Globalization.CultureInfo.InvariantCulture);
        return datetoConvert;

    }

    public static String converttoDateFormat(String date, String format)
    {
        DateTime datetoConvert = DateTime.ParseExact(date, @"dd/MM/yyyy", System.Globalization.CultureInfo.InvariantCulture);
        return datetoConvert.ToString(format);
    }

    public static DateTime generateRandomDateWithRange(Date StartRange, String dateType)
    {
        Random random = new Random();
        int randomNumber = random.Next(1, 5);
        DateTime todaysDate = StartRange;
        if (dateType.Equals("past", StringComparison.OrdinalIgnoreCase))
        {
            todaysDate = todaysDate.AddDays(-randomNumber);
        }
        else if (dateType.Equals("future", StringComparison.OrdinalIgnoreCase))
        {
            todaysDate = todaysDate.AddDays(random.Next(1, 5));
        }
        else if (dateType.Equals("current", StringComparison.OrdinalIgnoreCase))
        {
            todaysDate = DateTime.Today;
        }
        return todaysDate;
    }


    public static string GenerateTFNnumber()
    {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (count < 500000)
        {
            int randomNumber = random.Next(100000000, 999999999);
            if (ValidateTFN(randomNumber.ToString()))
            {
                sb.AppendLine(randomNumber.ToString());
                sb = sb.Replace(System.Environment.NewLine, string.Empty);
                break;
            }
            else
            {
                count++;
            }
        }
        return sb.ToString();
    }

    public static bool ValidateTFN(string tfn)
    {
        //validate only digits
        if (!IsNumeric(tfn)) return false;

        //validate length
        if (tfn.Length != 9) return false;

        int[] digits = Array.ConvertAll(tfn.ToArray(), c => (int)Char.GetNumericValue(c));

        //do the calcs
        var sum = (digits[0] * 1)
                + (digits[1] * 4)
                + (digits[2] * 3)
                + (digits[3] * 7)
                + (digits[4] * 5)
                + (digits[5] * 8)
                + (digits[6] * 6)
                + (digits[7] * 9)
                + (digits[8] * 10);

        var remainder = sum % 11;
        return (remainder == 0);
    }

    public static bool IsNumeric(string s)
    {
        float output;
        return float.TryParse(s, out output);
    }

    public static string GenerateSINNumber()
    {
        int[] s = GenerateSin();
        while (!SinIsValid(s))
            s = GenerateSin();
        string[] result = Array.ConvertAll(s, element => element.ToString());
        string sinno = string.Join("", result);
        return sinno;
    }

    private static int[] GenerateSin()
    {
        int[] s = new int[9];

        for (int i = 0; i < 9; i++)
            s[i] = r.Next(0, 10);

        return s;
    }

    private static bool SinIsValid(int[] sin)
    {
        if (sin.Length != 9)
            throw new ArgumentException();

        int checkSum = 0;

        for (int i = 0; i < sin.Length; i++)
        {
            int m = (i % 2) + 1;
            int v = sin[i] * m;
            if (v > 10)
                checkSum += 1 + (v - 10);
            else
                checkSum += v;
        }

        return checkSum % 10 == 0;
    }

    public static string GeneratePersonNumber(string date)
    {
        DateTime dt = DateTime.ParseExact(date, "MMMddyyyy",
                              CultureInfo.InvariantCulture);
        string formatdate = dt.ToString("yyyyMMdd");

        // Create first numbers
        var pNum = (formatdate + "-" + (new Random()).Next(100, 999).ToString());

        // get the control value sum
        var total = string.Join(string.Empty,
                            pNum.Substring(2, pNum.Length - 2)
                                .Select((value, i) =>
                                    ((int)(value - '0')) * (2 - (i % 2)))
                                ).Sum(c => c - '0');

        // add the control value to the number
        return (pNum += (Math.Ceiling(total / 10d) * 10) - total);
    }

    public static string GeneratePersonID(string date)
    {
        DateTime dt = DateTime.ParseExact(date, "MMMddyyyy",
                              CultureInfo.InvariantCulture);
        string formatdate = dt.ToString("ddMMyy");

        string birthyear = date.Substring(5, 4);

        int birthyearvalue = int.Parse(birthyear);
        int indno = 0;

        if ((birthyearvalue >= 1854) && birthyearvalue <= 1899)
        {
            if (Constants.Gender.Equals("Male"))
            {
                indno = RandomNumberOdd(500, 749);
            }
            else
            {
                indno = RandomNumberEven(500, 749);
            }
        }
        if ((birthyearvalue >= 2000) && birthyearvalue <= 2039)
        {
            if (Constants.Gender.Equals("Male"))
            {
                indno = RandomNumberOdd(500, 999);
            }
            else
            {
                indno = RandomNumberEven(500, 999);
            }
        }
        if ((birthyearvalue >= 1900) && birthyearvalue <= 1999)
        {
            if (Constants.Gender.Equals("Male"))
            {
                indno = RandomNumberOdd(0, 499);
            }
            else
            {
                indno = RandomNumberEven(0, 499);
            }
        }
        var number = formatdate + indno;
        string first = AddCheckDigitfirst(number);
        string second = AddCheckDigit(first);
        return second;
    }

    private static int RandomNumberEven(int min, int max)
    {
        Random random = new Random();
        int ans = random.Next(min, max);
        if (ans % 2 == 0) return ans;
        else
        {
            if (ans + 1 <= max)
                return ans + 1;
            else if (ans - 1 >= min)
                return ans - 1;
            else return 0;
        }
    }

    private static int RandomNumberOdd(int min, int max)
    {
        Random random = new Random();
        int ans = random.Next(min, max);
        if (ans % 2 == 1) return ans;
        else
        {
            if (ans + 1 <= max)
                return ans + 1;
            else if (ans - 1 >= min)
                return ans - 1;
            else return 0;
        }
    }

    public static string AddCheckDigit(string number)
    {
        int Sum = 0;
        for (int i = number.Length - 1, Multiplier = 2; i >= 0; i--)
        {
            Sum += (int)char.GetNumericValue(number[i]) * Multiplier;

            if (++Multiplier == 8) Multiplier = 2;
        }
        string Validator = (11 - (Sum % 11)).ToString();

        if (Validator == "11") Validator = "0";
        else if (Validator == "10") Validator = "1";

        return number + Validator;
    }

    public static string AddCheckDigitfirst(string number)
    {
        int Sum = 0;
        for (int i = number.Length - 1, Multiplier = 2; i >= 0; i--)
        {
            if (i == 0) Multiplier = 2;
            if (i == 1) Multiplier = 5;
            if (i == 2) Multiplier = 4;
            if (i == 3) Multiplier = 9;
            if (i == 4) Multiplier = 8;
            if (i == 5) Multiplier = 1;
            if (i == 6) Multiplier = 6;
            if (i == 7) Multiplier = 7;
            if (i == 8) Multiplier = 3;
            Sum += (int)char.GetNumericValue(number[i]) * Multiplier;
            //if (++Multiplier == 8) Multiplier = 2;
        }
        string Validator = (11 - (Sum % 11)).ToString();

        if (Validator == "11") Validator = "0";
        else if (Validator == "10") Validator = "X";

        return number + Validator;
    }

    public static void GenerateLog(string testcase, string company, string positionNo, string effdate, string personnelNo)
    {
        dynamic product = new JObject();
        if (!positionNo.Equals(""))
        {
            product.positionNumber = positionNo;
        }
        if (!personnelNo.Equals(""))
        {
            product.personnelNumber = personnelNo;
        }
        if (!effdate.Equals(""))
        {
            product.effectiveDate = effdate;
        }

        string path1 = AppDomain.CurrentDomain.BaseDirectory.Replace("\\bin\\Debug", "");
        string path = path1 + "JSON_Logs\\";
        File.WriteAllText(@path + testcase + "_" + company + ".json", product.ToString());
        //File.WriteAllText(@"C:\Users\v-bomaha\Desktop\Logs\" + testcase + "_" + company + ".json", product.ToString());
    }

    
    public static String GetCurrentuserName()
    {
        
            var curDir = Directory.GetCurrentDirectory();
            Console.WriteLine(curDir);
            string userName = System.Security.Principal.WindowsIdentity.GetCurrent().Name;
            userName = userName.Replace("FAREAST\\","");
            Console.WriteLine(userName);
            return userName;
    }

    public static String GetCurrentProjectDirectory()
    {
            string workingDirectory = Environment.CurrentDirectory;
            string projectDirectory = Directory.GetParent(workingDirectory).Parent.FullName;
            Console.WriteLine(projectDirectory);
            return projectDirectory;
    }


    public static void ONBHireMandatoryFieldsExist(string TestSuite, string URL, string CompanyCode, string PositionNo, string PositionType, string RestURL, string WorkFactor)
    {

        //string stringBuilder = "";
        List<string> stringBuilder = new List<string>();

        if (TestSuite.Equals("")||TestSuite.Equals(null))
        {

            Console.WriteLine(" The mandatory field TestSuite is empty in the TDS");
            //stringBuilder = string.Join(",","TestSuite");
            stringBuilder.Add("TestSuite");
        }

        if (URL.Equals(""))
        {
            Console.WriteLine(" The mandatory field URL is empty in the TDS");
            //stringBuilder = string.Join(",", "URL");
            stringBuilder.Add("URL");
        }

        if (CompanyCode.Equals(""))
        {
            Console.WriteLine(" The mandatory field CompanyCode is empty in the TDS");
            //stringBuilder = string.Join(",", "CompanyCode");
            stringBuilder.Add("CompanyCode");
        }

        if (PositionNo.Equals(""))
        {
            Console.WriteLine(" The mandatory field PositionNo is empty in the TDS");
            //stringBuilder = string.Join(",", "PositionNo");
            stringBuilder.Add("PositionNo");

        }

        if (PositionType.Equals(""))
        {
            Console.WriteLine(" The mandatory field PositionType is empty in the TDS");
            //stringBuilder = string.Join(",", "PositionType");
            stringBuilder.Add("PositionType");
        }


        if (RestURL.Equals(""))
        {
            Console.WriteLine(" The mandatory field RestURL is empty in the TDS");
            //stringBuilder = string.Join(",", "RestURL");
            stringBuilder.Add("RestURL");
        }

        if (WorkFactor.Equals(""))
        {
            Console.WriteLine(" The mandatory field WorkFactor is empty in the TDS");
            //stringBuilder = string.Join(",", "WorkFactor");
            stringBuilder.Add("WorkFactor");
        }

        string readable = string.Join("," ,stringBuilder);
        if(TestSuite.Equals("") || URL.Equals("") || CompanyCode.Equals("") || PositionNo.Equals("") || PositionType.Equals("") || RestURL.Equals("") || WorkFactor.Equals(""))
        {
            Assert.Fail(" The following mandatory fields needs to be filled in the TDS : " + readable);
        }


        //=======================================================================================================================================================================
        // Setup info
        //=======================================================================================================================================================================

        Constants.EventReason = "New Hire";
        Constants.ICIMSActionType = "Hire";
    }

    public static void ONBTransferMandatoryFieldsExist(String TestSuite, String URL, String CompanyCode, String PositionNo, String PositionType, String RestURL, String WorkFactor , String FirstName, String LasttName , String DOB , String Gender , String PersonId)
    {

        //string stringBuilder = "";
        List<String> stringBuilder = new List<String>();

        if (TestSuite.Equals("") || TestSuite.Equals(null))
        {

            Console.WriteLine(" The mandatory field TestSuite is empty in the TDS");
            //stringBuilder = string.Join(",","TestSuite");
            stringBuilder.Add("TestSuite");
        }

        if (URL.Equals(""))
        {
            Console.WriteLine(" The mandatory field URL is empty in the TDS");
            //stringBuilder = string.Join(",", "URL");
            stringBuilder.Add("URL");
        }

        if (CompanyCode.Equals(""))
        {
            Console.WriteLine(" The mandatory field CompanyCode is empty in the TDS");
            //stringBuilder = string.Join(",", "CompanyCode");
            stringBuilder.Add("CompanyCode");
        }

        if (PositionNo.Equals(""))
        {
            Console.WriteLine(" The mandatory field PositionNo is empty in the TDS");
            //stringBuilder = string.Join(",", "PositionNo");
            stringBuilder.Add("PositionNo");

        }

        if (PositionType.Equals(""))
        {
            Console.WriteLine(" The mandatory field PositionType is empty in the TDS");
            //stringBuilder = string.Join(",", "PositionType");
            stringBuilder.Add("PositionType");
        }


        if (RestURL.Equals(""))
        {
            Console.WriteLine(" The mandatory field RestURL is empty in the TDS");
            //stringBuilder = string.Join(",", "RestURL");
            stringBuilder.Add("RestURL");
        }

        if (WorkFactor.Equals(""))
        {
            Console.WriteLine(" The mandatory field WorkFactor is empty in the TDS");
            //stringBuilder = string.Join(",", "WorkFactor");
            stringBuilder.Add("WorkFactor");
        }

        if (FirstName.Equals(""))
        {
            Console.WriteLine(" The mandatory field FirstName is empty in the TDS");
            stringBuilder.Add("FirstName");
        }

        if (LasttName.Equals(""))
        {
            Console.WriteLine(" The mandatory field LasttName is empty in the TDS");
            stringBuilder.Add("LasttName");
        }

       
        if (Gender.Equals(""))
        {
            Console.WriteLine(" The mandatory field Gender is empty in the TDS");
            stringBuilder.Add("Gender");
        }

        if (DOB.Equals(""))
        {
            Console.WriteLine(" The mandatory field DOB is empty in the TDS");
            stringBuilder.Add("DOB");
        }

        if (PersonId.Equals(""))
        {
            Console.WriteLine(" The mandatory field PersonId is empty in the TDS");
            stringBuilder.Add("PersonId");
        }
        string readable = string.Join(",", stringBuilder);
        if (TestSuite.Equals("") || URL.Equals("") || CompanyCode.Equals("") || PositionNo.Equals("") || PositionType.Equals("") || RestURL.Equals("") || WorkFactor.Equals("") || FirstName.Equals("") || LasttName.Equals("") || DOB.Equals("") || Gender.Equals("") || PersonId.Equals(""))
        {
            Assert.Fail(" The following mandatory fields needs to be filled in the TDS : " + readable);
        }


        //=======================================================================================================================================================================
        // Setup info
        //=======================================================================================================================================================================

        Constants.EventReason = "Transfer";
        Constants.ICIMSActionType = "Sub to Corp Transfer";
        string url = RestURL;
        string positionNo = PositionNo;
        IDictionary<string, string> apicalls;

        apicalls = restapi.GetLocationDetailFromPosition(url, positionNo);
        Constants.Country = apicalls["Country"];
    }


    public static void ONBsubtosubTransferMandatoryFieldsExist(string TestSuite, string URL, string CompanyCode, string PositionNo, string PositionType, string RestURL, string WorkFactor, string FirstName, string LasttName, string DOB, string Gender, string PersonId)
    {

        //string stringBuilder = "";
        List<string> stringBuilder = new List<string>();

        if (TestSuite.Equals("") || TestSuite.Equals(null))
        {

            Console.WriteLine(" The mandatory field TestSuite is empty in the TDS");
            //stringBuilder = string.Join(",","TestSuite");
            stringBuilder.Add("TestSuite");
        }

        if (URL.Equals(""))
        {
            Console.WriteLine(" The mandatory field URL is empty in the TDS");
            //stringBuilder = string.Join(",", "URL");
            stringBuilder.Add("URL");
        }

        if (CompanyCode.Equals(""))
        {
            Console.WriteLine(" The mandatory field CompanyCode is empty in the TDS");
            //stringBuilder = string.Join(",", "CompanyCode");
            stringBuilder.Add("CompanyCode");
        }

        if (PositionNo.Equals(""))
        {
            Console.WriteLine(" The mandatory field PositionNo is empty in the TDS");
            //stringBuilder = string.Join(",", "PositionNo");
            stringBuilder.Add("PositionNo");

        }

        if (PositionType.Equals(""))
        {
            Console.WriteLine(" The mandatory field PositionType is empty in the TDS");
            //stringBuilder = string.Join(",", "PositionType");
            stringBuilder.Add("PositionType");
        }


        if (RestURL.Equals(""))
        {
            Console.WriteLine(" The mandatory field RestURL is empty in the TDS");
            //stringBuilder = string.Join(",", "RestURL");
            stringBuilder.Add("RestURL");
        }

        if (WorkFactor.Equals(""))
        {
            Console.WriteLine(" The mandatory field WorkFactor is empty in the TDS");
            //stringBuilder = string.Join(",", "WorkFactor");
            stringBuilder.Add("WorkFactor");
        }

        if (FirstName.Equals(""))
        {
            Console.WriteLine(" The mandatory field FirstName is empty in the TDS");
            stringBuilder.Add("FirstName");
        }

        if (LasttName.Equals(""))
        {
            Console.WriteLine(" The mandatory field LasttName is empty in the TDS");
            stringBuilder.Add("LasttName");
        }


        if (Gender.Equals(""))
        {
            Console.WriteLine(" The mandatory field Gender is empty in the TDS");
            stringBuilder.Add("Gender");
        }

        if (DOB.Equals(""))
        {
            Console.WriteLine(" The mandatory field DOB is empty in the TDS");
            stringBuilder.Add("DOB");
        }

        if (PersonId.Equals(""))
        {
            Console.WriteLine(" The mandatory field PersonId is empty in the TDS");
            stringBuilder.Add("PersonId");
        }
        string readable = string.Join(",", stringBuilder);
        if (TestSuite.Equals("") || URL.Equals("") || CompanyCode.Equals("") || PositionNo.Equals("") || PositionType.Equals("") || RestURL.Equals("") || WorkFactor.Equals("") || FirstName.Equals("") || LasttName.Equals("") || DOB.Equals("") || Gender.Equals("") || PersonId.Equals(""))
        {
            Assert.Fail(" The following mandatory fields needs to be filled in the TDS : " + readable);
        }


        //=======================================================================================================================================================================
        // Setup info
        //=======================================================================================================================================================================

        Constants.EventReason = "Transfer";
        Constants.ICIMSActionType = "Sub to Sub Transfer";
        string url = RestURL;
        string positionNo = PositionNo;
        IDictionary<string, string> apicalls;

        apicalls = restapi.GetLocationDetailFromPosition(url, positionNo);
        Constants.Country = apicalls["Country"];
        Constants.employeeID = PersonId;
    }

    public static void ONBsubtosubIntraTransferMandatoryFieldsExist(string TestSuite, string URL, string CompanyCode, string PositionNo, string PositionType, string RestURL, string WorkFactor, string FirstName, string LasttName, string DOB, string Gender, string PersonId)
    {
        //xfer02
        //string stringBuilder = "";
        List<string> stringBuilder = new List<string>();

        if (TestSuite.Equals("") || TestSuite.Equals(null))
        {

            Console.WriteLine(" The mandatory field TestSuite is empty in the TDS");
            //stringBuilder = string.Join(",","TestSuite");
            stringBuilder.Add("TestSuite");
        }

        if (URL.Equals(""))
        {
            Console.WriteLine(" The mandatory field URL is empty in the TDS");
            //stringBuilder = string.Join(",", "URL");
            stringBuilder.Add("URL");
        }

        if (CompanyCode.Equals(""))
        {
            Console.WriteLine(" The mandatory field CompanyCode is empty in the TDS");
            //stringBuilder = string.Join(",", "CompanyCode");
            stringBuilder.Add("CompanyCode");
        }

        if (PositionNo.Equals(""))
        {
            Console.WriteLine(" The mandatory field PositionNo is empty in the TDS");
            //stringBuilder = string.Join(",", "PositionNo");
            stringBuilder.Add("PositionNo");

        }

        if (PositionType.Equals(""))
        {
            Console.WriteLine(" The mandatory field PositionType is empty in the TDS");
            //stringBuilder = string.Join(",", "PositionType");
            stringBuilder.Add("PositionType");
        }


        if (RestURL.Equals(""))
        {
            Console.WriteLine(" The mandatory field RestURL is empty in the TDS");
            //stringBuilder = string.Join(",", "RestURL");
            stringBuilder.Add("RestURL");
        }

        if (WorkFactor.Equals(""))
        {
            Console.WriteLine(" The mandatory field WorkFactor is empty in the TDS");
            //stringBuilder = string.Join(",", "WorkFactor");
            stringBuilder.Add("WorkFactor");
        }

        if (FirstName.Equals(""))
        {
            Console.WriteLine(" The mandatory field FirstName is empty in the TDS");
            stringBuilder.Add("FirstName");
        }

        if (LasttName.Equals(""))
        {
            Console.WriteLine(" The mandatory field LasttName is empty in the TDS");
            stringBuilder.Add("LasttName");
        }


        if (Gender.Equals(""))
        {
            Console.WriteLine(" The mandatory field Gender is empty in the TDS");
            stringBuilder.Add("Gender");
        }

        if (DOB.Equals(""))
        {
            Console.WriteLine(" The mandatory field DOB is empty in the TDS");
            stringBuilder.Add("DOB");
        }

        if (PersonId.Equals(""))
        {
            Console.WriteLine(" The mandatory field PersonId is empty in the TDS");
            stringBuilder.Add("PersonId");
        }
        string readable = string.Join(",", stringBuilder);
        if (TestSuite.Equals("") || URL.Equals("") || CompanyCode.Equals("") || PositionNo.Equals("") || PositionType.Equals("") || RestURL.Equals("") || WorkFactor.Equals("") || FirstName.Equals("") || LasttName.Equals("") || DOB.Equals("") || Gender.Equals("") || PersonId.Equals(""))
        {
            Assert.Fail(" The following mandatory fields needs to be filled in the TDS : " + readable);
        }


        //=======================================================================================================================================================================
        // Setup info
        //=======================================================================================================================================================================

        Constants.EventReason = "Transfer";
        Constants.ICIMSActionType = "Intracompany Transfer";
        string url = RestURL;
        string positionNo = PositionNo;
        IDictionary<string, string> apicalls;

        apicalls = restapi.GetLocationDetailFromPosition(url, positionNo);
        Constants.Country = apicalls["Country"];
    }

    public static void ONBIntraCountryTransferMandatoryFieldsExist(string TestSuite, string URL, string CompanyCode, string PositionNo, string PositionType, string RestURL, string WorkFactor, string FirstName, string LastName, string DOB, string Gender, string PersonId)
    {
        //XFER01
        //string stringBuilder = "";
        List<string> stringBuilder = new List<string>();

        if (TestSuite.Equals("") || TestSuite.Equals(null))
        {

            Console.WriteLine(" The mandatory field TestSuite is empty in the TDS");
            //stringBuilder = string.Join(",","TestSuite");
            stringBuilder.Add("TestSuite");
        }

        if (URL.Equals(""))
        {
            Console.WriteLine(" The mandatory field URL is empty in the TDS");
            //stringBuilder = string.Join(",", "URL");
            stringBuilder.Add("URL");
        }

        if (CompanyCode.Equals(""))
        {
            Console.WriteLine(" The mandatory field CompanyCode is empty in the TDS");
            //stringBuilder = string.Join(",", "CompanyCode");
            stringBuilder.Add("CompanyCode");
        }

        if (PositionNo.Equals(""))
        {
            Console.WriteLine(" The mandatory field PositionNo is empty in the TDS");
            //stringBuilder = string.Join(",", "PositionNo");
            stringBuilder.Add("PositionNo");

        }

        if (PositionType.Equals(""))
        {
            Console.WriteLine(" The mandatory field PositionType is empty in the TDS");
            //stringBuilder = string.Join(",", "PositionType");
            stringBuilder.Add("PositionType");
        }


        if (RestURL.Equals(""))
        {
            Console.WriteLine(" The mandatory field RestURL is empty in the TDS");
            //stringBuilder = string.Join(",", "RestURL");
            stringBuilder.Add("RestURL");
        }

        if (WorkFactor.Equals(""))
        {
            Console.WriteLine(" The mandatory field WorkFactor is empty in the TDS");
            //stringBuilder = string.Join(",", "WorkFactor");
            stringBuilder.Add("WorkFactor");
        }

        if (FirstName.Equals(""))
        {
            Console.WriteLine(" The mandatory field FirstName is empty in the TDS");
            stringBuilder.Add("FirstName");
        }

        if (LastName.Equals(""))
        {
            Console.WriteLine(" The mandatory field LasttName is empty in the TDS");
            stringBuilder.Add("LasttName");
        }


        if (Gender.Equals(""))
        {
            Console.WriteLine(" The mandatory field Gender is empty in the TDS");
            stringBuilder.Add("Gender");
        }

        if (DOB.Equals(""))
        {
            Console.WriteLine(" The mandatory field DOB is empty in the TDS");
            stringBuilder.Add("DOB");
        }

        if (PersonId.Equals(""))
        {
            Console.WriteLine(" The mandatory field PersonId is empty in the TDS");
            stringBuilder.Add("PersonId");
        }
        string readable = string.Join(",", stringBuilder);
        if (TestSuite.Equals("") || URL.Equals("") || CompanyCode.Equals("") || PositionNo.Equals("") || PositionType.Equals("") || RestURL.Equals("") || WorkFactor.Equals("") || FirstName.Equals("") || LastName.Equals("") || DOB.Equals("") || Gender.Equals("") || PersonId.Equals(""))
        {
            Assert.Fail(" The following mandatory fields needs to be filled in the TDS : " + readable);
        }


        //=======================================================================================================================================================================
        // Setup info
        //=======================================================================================================================================================================

        Constants.EventReason = "Transfer";
        Constants.ICIMSActionType = "Intra- country Transfer"; 
        string url = RestURL;
        string positionNo = PositionNo;
        IDictionary<string, string> apicalls;

        apicalls = restapi.GetLocationDetailFromPosition(url, positionNo);
        Constants.Country = apicalls["Country"];
        Constants.firstname = FirstName;
        Constants.lastname = LastName;

    }


    public static void ONBnonECtoECTransferMandatoryFieldsExist(string TestSuite, string URL, string CompanyCode, string PositionNo, string PositionType, string RestURL, string WorkFactor, string FirstName, string LasttName, string DOB, string Gender, string PersonId , string iCIMSActionType)
    {

        //string stringBuilder = "";
        List<string> stringBuilder = new List<string>();

        if (TestSuite.Equals("") || TestSuite.Equals(null))
        {

            Console.WriteLine(" The mandatory field TestSuite is empty in the TDS");
            //stringBuilder = string.Join(",","TestSuite");
            stringBuilder.Add("TestSuite");
        }

        if (URL.Equals(""))
        {
            Console.WriteLine(" The mandatory field URL is empty in the TDS");
            //stringBuilder = string.Join(",", "URL");
            stringBuilder.Add("URL");
        }

        if (CompanyCode.Equals(""))
        {
            Console.WriteLine(" The mandatory field CompanyCode is empty in the TDS");
            //stringBuilder = string.Join(",", "CompanyCode");
            stringBuilder.Add("CompanyCode");
        }

        if (PositionNo.Equals(""))
        {
            Console.WriteLine(" The mandatory field PositionNo is empty in the TDS");
            //stringBuilder = string.Join(",", "PositionNo");
            stringBuilder.Add("PositionNo");

        }

        if (PositionType.Equals(""))
        {
            Console.WriteLine(" The mandatory field PositionType is empty in the TDS");
            //stringBuilder = string.Join(",", "PositionType");
            stringBuilder.Add("PositionType");
        }


        if (RestURL.Equals(""))
        {
            Console.WriteLine(" The mandatory field RestURL is empty in the TDS");
            //stringBuilder = string.Join(",", "RestURL");
            stringBuilder.Add("RestURL");
        }

        if (WorkFactor.Equals(""))
        {
            Console.WriteLine(" The mandatory field WorkFactor is empty in the TDS");
            //stringBuilder = string.Join(",", "WorkFactor");
            stringBuilder.Add("WorkFactor");
        }

        if (FirstName.Equals(""))
        {
            Console.WriteLine(" The mandatory field FirstName is empty in the TDS");
            stringBuilder.Add("FirstName");
        }

        if (LasttName.Equals(""))
        {
            Console.WriteLine(" The mandatory field LasttName is empty in the TDS");
            stringBuilder.Add("LasttName");
        }


        if (Gender.Equals(""))
        {
            Console.WriteLine(" The mandatory field Gender is empty in the TDS");
            stringBuilder.Add("Gender");
        }

        if (DOB.Equals(""))
        {
            Console.WriteLine(" The mandatory field DOB is empty in the TDS");
            stringBuilder.Add("DOB");
        }

        if (PersonId.Equals(""))
        {
            Console.WriteLine(" The mandatory field PersonId is empty in the TDS");
            stringBuilder.Add("PersonId");
        }

        if (iCIMSActionType.Equals(""))
        {
            Console.WriteLine(" The mandatory field iCIMSActionType is empty in the TDS");
            stringBuilder.Add("iCIMSActionType");
        }
        string readable = string.Join(",", stringBuilder);
        if (TestSuite.Equals("") || URL.Equals("") || CompanyCode.Equals("") || PositionNo.Equals("") || PositionType.Equals("") || RestURL.Equals("") || WorkFactor.Equals("") || FirstName.Equals("") || LasttName.Equals("") || DOB.Equals("") || Gender.Equals("") || PersonId.Equals("") || iCIMSActionType.Equals(""))
        {
            Assert.Fail(" The following mandatory fields needs to be filled in the TDS : " + readable);
        }


        //=======================================================================================================================================================================
        // Setup info
        //=======================================================================================================================================================================

        Constants.EventReason = "Transfer";
        Constants.ICIMSActionType = iCIMSActionType;
        string url = RestURL;
        string positionNo = PositionNo;
        IDictionary<string, string> apicalls;

        apicalls = restapi.GetLocationDetailFromPosition(url, positionNo);
        Constants.Country = apicalls["Country"];
    }


    public static void ONBselfIdtononselfIdTransferMandatoryFieldsExist(string TestSuite, string URL, string CompanyCode, string PositionNo, string PositionType, string RestURL, string WorkFactor, string FirstName, string LasttName, string DOB, string Gender, string PersonId)
    {

        //string stringBuilder = "";
        List<string> stringBuilder = new List<string>();

        if (TestSuite.Equals("") || TestSuite.Equals(null))
        {

            Console.WriteLine(" The mandatory field TestSuite is empty in the TDS");
            //stringBuilder = string.Join(",","TestSuite");
            stringBuilder.Add("TestSuite");
        }

        if (URL.Equals(""))
        {
            Console.WriteLine(" The mandatory field URL is empty in the TDS");
            //stringBuilder = string.Join(",", "URL");
            stringBuilder.Add("URL");
        }

        if (CompanyCode.Equals(""))
        {
            Console.WriteLine(" The mandatory field CompanyCode is empty in the TDS");
            //stringBuilder = string.Join(",", "CompanyCode");
            stringBuilder.Add("CompanyCode");
        }

        if (PositionNo.Equals(""))
        {
            Console.WriteLine(" The mandatory field PositionNo is empty in the TDS");
            //stringBuilder = string.Join(",", "PositionNo");
            stringBuilder.Add("PositionNo");

        }

        if (PositionType.Equals(""))
        {
            Console.WriteLine(" The mandatory field PositionType is empty in the TDS");
            //stringBuilder = string.Join(",", "PositionType");
            stringBuilder.Add("PositionType");
        }


        if (RestURL.Equals(""))
        {
            Console.WriteLine(" The mandatory field RestURL is empty in the TDS");
            //stringBuilder = string.Join(",", "RestURL");
            stringBuilder.Add("RestURL");
        }

        if (WorkFactor.Equals(""))
        {
            Console.WriteLine(" The mandatory field WorkFactor is empty in the TDS");
            //stringBuilder = string.Join(",", "WorkFactor");
            stringBuilder.Add("WorkFactor");
        }

        if (FirstName.Equals(""))
        {
            Console.WriteLine(" The mandatory field FirstName is empty in the TDS");
            stringBuilder.Add("FirstName");
        }

        if (LasttName.Equals(""))
        {
            Console.WriteLine(" The mandatory field LasttName is empty in the TDS");
            stringBuilder.Add("LasttName");
        }


        if (Gender.Equals(""))
        {
            Console.WriteLine(" The mandatory field Gender is empty in the TDS");
            stringBuilder.Add("Gender");
        }

        if (DOB.Equals(""))
        {
            Console.WriteLine(" The mandatory field DOB is empty in the TDS");
            stringBuilder.Add("DOB");
        }

        if (PersonId.Equals(""))
        {
            Console.WriteLine(" The mandatory field PersonId is empty in the TDS");
            stringBuilder.Add("PersonId");
        }
        string readable = string.Join(",", stringBuilder);
        if (TestSuite.Equals("") || URL.Equals("") || CompanyCode.Equals("") || PositionNo.Equals("") || PositionType.Equals("") || RestURL.Equals("") || WorkFactor.Equals("") || FirstName.Equals("") || LasttName.Equals("") || DOB.Equals("") || Gender.Equals("") || PersonId.Equals(""))
        {
            Assert.Fail(" The following mandatory fields needs to be filled in the TDS : " + readable);
        }


        //=======================================================================================================================================================================
        // Setup info
        //=======================================================================================================================================================================

        Constants.EventReason = "Transfer";
        Constants.ICIMSActionType = "Sub to Sub Transfer";
        string url = RestURL;
        string positionNo = PositionNo;
        IDictionary<string, string> apicalls;

        apicalls = restapi.GetLocationDetailFromPosition(url, positionNo);
        Constants.Country = apicalls["Country"];
    }

    public static void CStoFTEHireMandatoryFieldsExist(string TestSuite, string URL, string CompanyCode, string PositionNo, string PositionType, string RestURL, string WorkFactor , string FirstName, string LastName, string LastKnownPernerNo, string EmailAlias,string EventReason, string ICMSTYPE)
    {

        //string stringBuilder = "";
        List<string> stringBuilder = new List<string>();

        if (TestSuite.Equals("") || TestSuite.Equals(null))
        {

            Console.WriteLine(" The mandatory field TestSuite is empty in the TDS");
            //stringBuilder = string.Join(",","TestSuite");
            stringBuilder.Add("TestSuite");
        }

        if (URL.Equals(""))
        {
            Console.WriteLine(" The mandatory field URL is empty in the TDS");
            //stringBuilder = string.Join(",", "URL");
            stringBuilder.Add("URL");
        }

        if (CompanyCode.Equals(""))
        {
            Console.WriteLine(" The mandatory field CompanyCode is empty in the TDS");
            //stringBuilder = string.Join(",", "CompanyCode");
            stringBuilder.Add("CompanyCode");
        }

        if (PositionNo.Equals(""))
        {
            Console.WriteLine(" The mandatory field PositionNo is empty in the TDS");
            //stringBuilder = string.Join(",", "PositionNo");
            stringBuilder.Add("PositionNo");

        }

        if (PositionType.Equals(""))
        {
            Console.WriteLine(" The mandatory field PositionType is empty in the TDS");
            //stringBuilder = string.Join(",", "PositionType");
            stringBuilder.Add("PositionType");
        }


        if (RestURL.Equals(""))
        {
            Console.WriteLine(" The mandatory field RestURL is empty in the TDS");
            //stringBuilder = string.Join(",", "RestURL");
            stringBuilder.Add("RestURL");
        }

        if (WorkFactor.Equals(""))
        {
            Console.WriteLine(" The mandatory field WorkFactor is empty in the TDS");
            //stringBuilder = string.Join(",", "WorkFactor");
            stringBuilder.Add("WorkFactor");
        }

        if (FirstName.Equals(""))
        {
            Console.WriteLine(" The mandatory field FirstName is empty in the TDS");
            //stringBuilder = string.Join(",", "WorkFactor");
            stringBuilder.Add("FirstName");
        }


        if (LastName.Equals(""))
        {
            Console.WriteLine(" The mandatory field LastName is empty in the TDS");
            //stringBuilder = string.Join(",", "WorkFactor");
            stringBuilder.Add("LastName");
        }


        if (LastKnownPernerNo.Equals(""))
        {
            Console.WriteLine(" The mandatory field LastKnownPernerNo is empty in the TDS");
            //stringBuilder = string.Join(",", "WorkFactor");
            stringBuilder.Add("LastKnownPernerNo");
        }

        if (URL.Equals(""))
        {
            Console.WriteLine(" The mandatory field URL is empty in the TDS");
            //stringBuilder = string.Join(",", "URL");
            stringBuilder.Add("URL");
        }

        if (CompanyCode.Equals(""))
        {
            Console.WriteLine(" The mandatory field CompanyCode is empty in the TDS");
            //stringBuilder = string.Join(",", "CompanyCode");
            stringBuilder.Add("CompanyCode");
        }

        if (PositionNo.Equals(""))
        {
            Console.WriteLine(" The mandatory field PositionNo is empty in the TDS");
            //stringBuilder = string.Join(",", "PositionNo");
            stringBuilder.Add("PositionNo");

        }

        if (PositionType.Equals(""))
        {
            Console.WriteLine(" The mandatory field PositionType is empty in the TDS");
            //stringBuilder = string.Join(",", "PositionType");
            stringBuilder.Add("PositionType");
        }


        if (RestURL.Equals(""))
        {
            Console.WriteLine(" The mandatory field RestURL is empty in the TDS");
            //stringBuilder = string.Join(",", "RestURL");
            stringBuilder.Add("RestURL");
        }

        if (WorkFactor.Equals(""))
        {
            Console.WriteLine(" The mandatory field WorkFactor is empty in the TDS");
            //stringBuilder = string.Join(",", "WorkFactor");
            stringBuilder.Add("WorkFactor");
        }

        if (FirstName.Equals(""))
        {
            Console.WriteLine(" The mandatory field FirstName is empty in the TDS");
            //stringBuilder = string.Join(",", "WorkFactor");
            stringBuilder.Add("FirstName");
        }


        if (LastName.Equals(""))
        {
            Console.WriteLine(" The mandatory field LastName is empty in the TDS");
            //stringBuilder = string.Join(",", "WorkFactor");
            stringBuilder.Add("LastName");
        }


        if (LastKnownPernerNo.Equals(""))
        {
            Console.WriteLine(" The mandatory field LastKnownPernerNo is empty in the TDS");
            //stringBuilder = string.Join(",", "WorkFactor");
            stringBuilder.Add("LastKnownPernerNo");
        }

        /*
        if (EmailAlias.Equals(""))
        {
            Console.WriteLine(" The mandatory field EmailAlias is empty in the TDS");
            //stringBuilder = string.Join(",", "WorkFactor");
            stringBuilder.Add("EmailAlias");
        }*/
        
        string readable = string.Join(",", stringBuilder);
        if (TestSuite.Equals("") || URL.Equals("") || CompanyCode.Equals("") || PositionNo.Equals("") || PositionType.Equals("") || RestURL.Equals("") || WorkFactor.Equals("") || FirstName.Equals("") || LastName.Equals("")|| LastKnownPernerNo.Equals(""))
        {
            Assert.Fail(" The following mandatory fields needs to be filled in the TDS : " + readable);
        }


        //=======================================================================================================================================================================
        // Setup info
        //=======================================================================================================================================================================
        if (!EventReason.Equals(""))
        {
            Constants.EventReason = EventReason;
        }
        if (!ICMSTYPE.Equals(""))
        {
            Constants.ICIMSActionType = ICMSTYPE;
        }
        /*Constants.EventReason = "External Staff to EE";
        Constants.ICIMSActionType = "External Staff to FTE";*/
        Constants.employeeID = LastKnownPernerNo;
        Constants.EmailAlias=EmailAlias;
        string url = RestURL;
        string positionNo = PositionNo;
        IDictionary<string, string> apicalls;

        apicalls = restapi.GetLocationDetailFromPosition(url, positionNo);
        Constants.Country = apicalls["Country"];
    }

    




}

}
