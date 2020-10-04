package bn;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Management {

    private List<Patient> patientList;

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public Management(List<Patient> patients) {
        patientList = patients;
    }

    public Management() {
    }

    public List<Patient> readFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("listpatinet.dat");
        ObjectInputStream ojb = new ObjectInputStream(fileInputStream);
        this.patientList = (ArrayList<Patient>) (ojb.readObject());
        ojb.close();
        fileInputStream.close();
        return this.patientList;
    }

    public void writeToFile() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("listpatinet.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(this.patientList);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    public void addInfos() throws IOException, ClassNotFoundException {
        this.patientList = readFile();
        Outpatients outpatients = new Outpatients();
        TransferPatient transferPatient = new TransferPatient();
        Inpatient inpatient = new Inpatient();
        System.out.println("Nhập Thông Tin Bệnh Nhân : ");
        System.out.println("1 : Bệnh Nhân Ngoại Trú ");
        System.out.println("2 : Bệnh Nhân Chuyển Viện ");
        System.out.println("3 : Bệnh Nhân Nội Trú ");
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        switch (n) {
            case 1:
                System.out.println("New Enter Information");
                outpatients.addInfo();
                patientList.add(outpatients);
                break;
            case 2:
                System.out.println("New Enter Information");
                transferPatient.addInfo();
                patientList.add(transferPatient);
                break;
            case 3:
                System.out.println("New Enter Information");
                inpatient.addInfo();
                patientList.add(inpatient);
                break;
        }
    }

    public void show() throws IOException, ClassNotFoundException {
        writeToFile();
        readFile();
        patientList.sort(new SortStudentByName());
        System.out.println("Hiện Thị Theo Thông Tin :");
        System.out.println("1 : Bệnh Nhân Ngoại Trú ");
        System.out.println("2 : Bệnh Nhân Chuyển Viện ");
        System.out.println("3 : Bệnh Nhân Nội Trú ");
        System.out.println("4 : Toàn Bộ Bệnh Nhân ");
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        switch (n) {
            case 1:
                for (Patient bn : patientList) {
                    if (bn instanceof Outpatients) {
                        System.out.println(bn.toString());
                    }
                }
                break;

            case 2:
                for (Patient bn : patientList) {
                    if (bn instanceof TransferPatient) {
                        System.out.println(bn.toString());
                    }
                }
                break;

            case 3:
                for (Patient bn : patientList) {
                    if (bn instanceof Inpatient) {
                        System.out.println(bn.toString());
                    }
                }
                break;

            case 4:
                for (Patient bn : patientList) {
                    System.out.println(bn.toString());
                }
                break;
        }
    }

    public void search(String regex) {
        int index = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        for (int i = 0; i < patientList.size(); i++) {
            matcher = pattern.matcher(patientList.get(i).getFullName());
            if (matcher.find()) {
                System.out.println("STT " + i + " : " + patientList.get(i).toString());
                index++;
            }
        }
        if (index <= 0) {
            System.out.println("This name is not on the list ");
        }
    }

    public void edit(int n) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tên Cần Chỉnh :");
        switch (n) {
            case 1:
                String edit = sc.nextLine();
                for (Patient name : patientList) {
                    if (edit.equals(name.getFullName())) {
                        System.out.println("Chỉnh tên : ");
                        String add = sc.nextLine();
                        name.setFullName(add);
                        System.out.println("Name after editing " + name.getFullName());
                    }
                }
                break;
            case 2:
                String edits = sc.nextLine();
                for (Patient Diagnosis : patientList) {
                    if (edits.equals(Diagnosis.getFullName())) {
                        System.out.println("Chuẩn Đoán Lại : ");
                        String add = sc.nextLine();
                        Diagnosis.setDiagnosis(add);
                        System.out.println("Name after editing " + Diagnosis.getDiagnosis());
                    }
                }
                break;

            case 3:
                String editor = sc.nextLine();
                for (Patient insuranceBook : patientList) {
                    Outpatients bnt = (Outpatients) insuranceBook;
                    if (editor.equals(bnt.getFullName())) {
                        System.out.println("Chỉnh Số Sổ Bảo Hiểm : ");
                        String add = sc.nextLine();
                        bnt.setInsuranceBook(add);
                        System.out.println("Sau khi chỉnh : " + bnt.getInsuranceBook());
                    }
                }
                break;

            case 4:
                String editors = sc.nextLine();
                for (Patient facultyName : patientList) {
                    Inpatient bnt = (Inpatient) facultyName;
                    if (editors.equals(bnt.getFullName())) {
                        System.out.println("Chỉnh Tên Khoa : ");
                        String add = sc.nextLine();
                        bnt.setFacultyName(add);
                        System.out.println("Sau khi chỉnh : " + bnt.getFacultyName());
                    }
                }
                break;
        }
    }

    public void delete(String id) {
        Patient patient = null;
        int size = patientList.size();
        for (int i = 0; i < size; i++) {
            if (patientList.get(i).getProfileCode().equals(id)) {
                patient = patientList.get(i);
                break;
            }
        }
        if (patient != null) {
            System.out.println("Bệnh Nhân Đã Xóa Tên Là : \n" + patient.getFullName());
            patientList.remove(patient);
        } else {
            System.out.printf("id = %d not existed.\n", id);
        }
    }

    public int inputMenu() {
        System.out.print("Input student id: ");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int id = Integer.parseInt((scanner.nextLine()));
                return id;
            } catch (NumberFormatException | NullPointerException ex) {
                System.out.print("Chọn Chức Năng Đê Bạn Ê : ");
            }
        }
    }


}
