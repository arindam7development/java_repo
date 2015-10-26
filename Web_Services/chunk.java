List<Double> homework = null;
        for (int i = 0; i < myDocs.size()-1; i++) {
            System.out.println("****"+count+"****");
            System.out.println(myDocs.get(i).getDouble("student_id"));
            System.out.println(myDocs.get(i+1).getDouble("student_id"));
            if (myDocs.get(i).getDouble("student_id").equals(myDocs.get(i+1).getDouble("student_id")) ){
                System.out.println("true");
                System.out.println("duplicate item "+myDocs.get(i+1).getDouble("student_id")+" at Location"+(i+1) );
                homework.add(myDocs.get(i+1).getDouble("student_id"));

            }
