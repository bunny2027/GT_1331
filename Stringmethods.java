public class Stringmethods{

    public static void strings(){
    String my_name = "Brandon";
    System.out.println(my_name);
    String clipped = my_name.replace('B', 'A');
    String clipped2 = clipped.substring(0, clipped.length() - 1) + "Z";
    System.out.println(clipped2);

    String url = "www.gatech.edu";
    System.out.println(url);

    String n_url = url.substring(4,url.length()- 3) +"1331";
    String nn_url = n_url.replace(".","");
    System.out.println(nn_url);
    }
    public static void main(String[] args){
        strings();
    }
}