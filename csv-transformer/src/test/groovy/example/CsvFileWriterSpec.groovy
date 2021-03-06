package example;

import spock.lang.Specification;

class CsvFileWriterSpec extends Specification {

	CsvFileWriter writer = new CsvFileWriter()

	void "Should write to a csv file"(){
		given:"A path"
		  String path = 'src/test/resources/csv_written.txt'
    and:"Some targets"
      Target t1 = new Target(id:'1',name:'eric',email:'erich@email.com')
      Target t2 = new Target(id:'2',name:'martin',email:'martinv@email.com')
      Target t3 = new Target(id:'3',name:'josdem',email:'josdem@email.com')
      List<Target> targets = [t1,t2,t3]
		when:
		writer.write(targets,path);
    File file = new File(path)
		then:"We expect file exist"
    List<String> lines = []
    file.eachLine { line ->
      lines << line
    }
    lines.get(0) == 'id	name	email'
    lines.get(1) == '1	eric	erich@email.com'
    lines.get(2) == '2	martin	martinv@email.com'
    lines.get(3) == '3	josdem	josdem@email.com'
	}


}
