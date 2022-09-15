import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class CheckData {

    private Date date1;
    private Date date2;
    public boolean isNumeric(String line){
        return line.matches(".*[0-9].*");
    }

    public boolean isString (String line){
        return line.contains("\"");
    }

    public boolean isDate(String line){
        String[] lineDivide = line.split(" ");
        String dateRaw1 = lineDivide[0];
        String dateRaw2 = lineDivide[2];
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            dateFormat.setLenient(false);
            this.date1 = dateFormat.parse(dateRaw1);
            this.date2 = dateFormat.parse(dateRaw2);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public String operateNumbers(String line){
        String[] lineDivided = line.split(" ");
        String operator = lineDivided[1];
        int result;

        if(operator.contains("+")){
            result = Integer.parseInt(lineDivided[0]) + Integer.parseInt(lineDivided[2]);
            return String.valueOf(result);
        }

        if(operator.contains("-")) {
            result = Integer.parseInt(lineDivided[0]) - Integer.parseInt(lineDivided[2]);
            return String.valueOf(result);
        }
        if(operator.contains("/")) {
            result = Integer.parseInt(lineDivided[0]) / Integer.parseInt(lineDivided[2]);
            return String.valueOf(result);
        }

        if(operator.contains("*")) {
            result = Integer.parseInt(lineDivided[0]) * Integer.parseInt(lineDivided[2]);
            return String.valueOf(result);
        }

        return "Operador no válido";

    }

    public String concactString(String line){
        line = line.replace("\"","");
        line = line.replace("+","");
        String[] lineDivided = line.split(" ");
        String result = "";

        for (String l:lineDivided){
            result += l;
        }

        return result;

    }

    public String compareDate(String line){

        String[] lineDivide = line.split(" ");

        if(lineDivide[1].contains("<")){

            return String.valueOf(this.date1.before(this.date2));
        }

        if(lineDivide[1].contains(">")){

            return String.valueOf(this.date1.after(this.date2));
        }

        if(lineDivide[1].contains("=")){

            return String.valueOf(this.date1.equals(this.date2));
        }

        return "Operador Inválido";

    }

    public String tidyLines(String line){

        if(this.isString(line)) {
            return this.concactString(line);
        }
         if (this.isDate(line)) {
             return this.compareDate(line);
        }
         if(this.isNumeric(line)){
             return String.valueOf(this.operateNumbers(line));
        }
         return "Dato no reconocido";
    }

}
