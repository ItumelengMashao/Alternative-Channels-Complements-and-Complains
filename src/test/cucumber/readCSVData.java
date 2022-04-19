import io.restassured.response.Response;

import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class readCSVData {
    private static String parentDirectory = "src\\main\\resources";
    private   String issueprojectkey;
    private   String issuetitle;
    private   String issuecontents;
    private   String issuecontactperson;
    private String issuetype;
    private String issuestatus;
    private String issuepriority;
    private String issueassignedto;
    private String issueaction;
    private String i01;

    public  synchronized   String mains() {
        iterateThroughFiles(parentDirectory).stream().forEach(fileName -> {
            if (fileName.toString().toLowerCase().endsWith(".csv")) {
                String line = "";
                String[] headers;
                List<ConcurrentHashMap<String,String>> fileList = new ArrayList<>();
                String[] row;
                List<String> fileContent = new ArrayList<>();
                try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

                    headers = br.readLine().split(",");
                    while ((line = br.readLine()) != null) {
                        row = line.split(",");
                        ConcurrentHashMap<String,String> temp= new ConcurrentHashMap<>();
                        for(int i =0;i<headers.length;i++)
                        {
                            temp.put(headers[i], row[i]);
                            fileList.add(temp);
                        }
                        fileContent.add(line);
                    }
                     issueprojectkey=fileList.get(0).get("issueprojectkey");
                     issuetitle=fileList.get(0).get("issuetitle");
                     issuecontents =fileList.get(0).get("issuecontents");
                     issuecontactperson =fileList.get(0).get("issuecontactperson");
                    issuetype =fileList.get(0).get("issuetype");
                    issuestatus =fileList.get(0).get("issuestatus");
                    issuepriority =fileList.get(0).get("issuepriority");
                    issueassignedto =fileList.get(0).get("issueassignedto");
                    issueaction =fileList.get(0).get("issueaction");
                    i01 =fileList.get(0).get("i01");


                    RestAssured.baseURI = "http://schemas.xmlsoap.org/soap/envelope";
                    String request = "<issue>" +
                                        "<issueprojectkey>'"+issueprojectkey+"'</issueprojectkey>"+
                                        "<issuetitle>'"+issuetitle+"'<issuetitle>"+
                                        "<issuecontents>'"+ issuecontents +"'</issuecontents>"+
                                        "<issuecontactperson>'"+ issuecontactperson +"'</issuecontactperson>"+
                                        "<issuetype>'"+ issuetype +"'</issuetype>"+
                                        "<issuestatus>'"+ issuestatus +"'</issuestatus>"+
                                        "<issuepriority>'"+ issuepriority +"'</issuepriority>"+
                                        "<issueassignedto>'"+ issueassignedto +"'</issueassignedto>"+
                                        "<issueaction>'"+ issueaction +"'</issueaction>"+
                                        "<i01>'"+ i01 +"'<i01/>"+
                            "</issue>";


                    Response response = null;

                    response = given().
                            contentType(ContentType.XML)
                            .accept(ContentType.XML)
                            .body(request)
                            .when()
                            .post("/addClient");

                    System.out.println("Post Response :" + response.asString());
                    System.out.println("Status Code :" + response.getStatusCode());
                    System.out.println(" Reponse " + response.asString());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return issueprojectkey+","+issuetitle+","+ issuecontents +","+ issuecontactperson;
    }
    public static List<File> iterateThroughFiles(String pathname) {
        List<File> files = new ArrayList<>();
        File file = new File(pathname);
        if (file.isDirectory()) {
            files = Arrays.asList(file.listFiles());
        }
        return files;
    }
}
