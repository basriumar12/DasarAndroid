package info.blogbasbas.hari3;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ResponseModel{

	@SerializedName("records")
	private List<RecordsItem> records;

	public void setRecords(List<RecordsItem> records){
		this.records = records;
	}

	public List<RecordsItem> getRecords(){
		return records;
	}

	@Override
 	public String toString(){
		return 
			"ResponseModel{" + 
			"records = '" + records + '\'' + 
			"}";
		}
}