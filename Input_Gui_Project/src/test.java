public class test {
    public static void main(String[] args) {
        String text = "INSO4101-080";
        String curso = text.substring(0, 8);
        String section = text.substring(9);

        System.out.print(text.charAt(8));
        System.out.print(text.charAt(8) == '-');
        
    }
}
