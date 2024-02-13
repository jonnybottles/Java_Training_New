package com.jonathan.datamodel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.util.Scanner;

@XmlRootElement
public class CryptKeeper {

    private AES256 theAES256;

    private String cleartextData;

    private String filePath;

    private String fileData;

    private Scanner fileReader;


    private String encryptedData;

    public CryptKeeper() {
        this.theAES256 = new AES256();
    }

    public String getCleartextData() {
        return cleartextData;
    }

    public String getFileData() {
        return fileData;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setCleartextData(String cleartextData) {
        this.cleartextData = cleartextData;
    }

    @XmlElement(name = "encryptedData")
    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    // Method for opening a file.
    public boolean openReadFile(String filePath) {
        try {
            fileReader = new Scanner(new File(filePath));
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    public void readFile() {
        // Set file data to empty string each time through as
        // files are read multiple times during the program operations.
        fileData = "";

        StringBuilder sb = new StringBuilder();
        try {
            while (fileReader.hasNextLine()) {
                sb.append(fileReader.nextLine());
                sb.append(System.lineSeparator());
            }
            fileData = sb.toString();
        } catch (Exception e) {
            return;
        }
    }
    public boolean writeEncryptedDataToFile(String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(CryptKeeper.class);
            Marshaller marshaller = context.createMarshaller();
            // Sets XML to be formatted with line breaks / indentation, making XML easier to read
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            File file = new File(filePath);

            marshaller.marshal(this, file);
            return true;


        } catch (JAXBException e) {
            e.printStackTrace();
            System.out.println("Marshalling data error **** NOTE DELETE LATER FOR DEBUGGING PURPOSES ONLY");
            return false;
        }
    }

    public static CryptKeeper readEncryptedDataFromFile(String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(CryptKeeper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (CryptKeeper) unmarshaller.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            System.err.println("Unmarshalling data error **** NOTE DELETE LATER FOR DEBUGGING PURPOSES ONLY");
            return null;
        }
    }

}
