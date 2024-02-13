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


    private String encryptedData;

    public CryptKeeper() {
        this.theAES256 = new AES256();
    }

    public String getCleartextData() {
        return cleartextData;
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

    public String readFile() {
        StringBuilder fileData = new StringBuilder();
        File file = new File(filePath);
        try (Scanner fileReader = new Scanner(file)) {
            while (fileReader.hasNextLine()) {
                fileData.append(fileReader.nextLine());
                fileData.append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            return "File not found: " + filePath;
        }
        return fileData.toString();
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
