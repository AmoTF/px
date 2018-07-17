package moi;

import java.util.List;

import com.carnation.mong.platform.domain.MOIDRelation;
import com.carnation.mong.platform.domain.MOIData;
import com.carnation.mong.platform.domain.MOIIniter;
import com.carnation.mong.platform.domain.MOIModel;
import com.carnation.mong.platform.domain.MOIRelationType;
import com.carnation.mong.platform.service.Connection;
import com.carnation.mong.platform.service.DRelationService;
import com.carnation.mong.platform.service.DataService;
import com.carnation.mong.platform.service.MOISession;
import com.carnation.mong.platform.service.ModelAttributeService;
import com.carnation.mong.platform.service.RelationTypeService;
import com.carnation.mong.platform.service.SessionFactory;

/**
 * @author ZTF
 * @version 创建时间：2018年7月16日 下午3:52:25 类说明
 */
public class MoiConnection {

	public static void main(String[] args) throws Exception {
		String ip = "localhost";
		int port = 1499;
		String userName = "admin";
		String userPassword = "admin";
		MOIIniter.init(ip, port);
		SessionFactory sf = MOIIniter.createSessionFactory();
		MOISession session = sf.createSession(userName, userPassword);
		Connection conn = session.createConnection();

		DataService ds = conn.createDataService();
		ModelAttributeService mas = session.createModelAttributeService();

		/*
		 * MOIModel region = mas.getModelByPath("HR.Region"); MOIModel country =
		 * mas.getModelByPath("HR.Country"); System.out.println(region.getName());
		 * System.out.println(country.getName()); MOIData asia = new
		 * MOIData(region.getId(), "asia"); asia = ds.create(asia);
		 * System.out.println("121" + asia.getName()); MOIData china = new
		 * MOIData(country.getId(), "China"); china.setParentId(asia.getId()); china =
		 * ds.create(china); conn.commit(); System.out.println(111);
		 */

		/*MOIModel country = mas.getModelByPath("HR.Country");
		MOIModel location = mas.getModelByPath("HR.Location");
		MOIModel department = mas.getModelByPath("HR.Department");
		MOIModel employee = mas.getModelByPath("HR.Employee");
		MOIModel job = mas.getModelByPath("HR.Job");
		MOIModel region = mas.getModelByPath("HR.Country");
		System.out.println(location.getName());
		System.out.println(department.getName());
		System.out.println(employee.getName());
		System.out.println(job.getName());
		System.out.println(country.getName());
		List<MOIData> regions = ds.getDatas(region.getId());
		MOIData china = null;
		for (MOIData region1 : regions) {
			if (region1.getName().equals("China")) {
				china = region1;
			}
		}
		MOIData peking = new MOIData(location.getId(), "peking");
		peking.setParentId(china.getId());
		peking = ds.create(peking);

		MOIData IT = new MOIData(department.getId(), "IT");
		IT.setParentId(peking.getId());
		IT = ds.create(IT);
		MOIData chen = new MOIData(employee.getId(), "chen");
		chen.setParentId(IT.getId());
		chen = ds.create(chen);
		MOIData programmer = new MOIData(job.getId(), "programmer");
		programmer = ds.create(programmer);
		System.out.println("programmer"+programmer);

		RelationTypeService rts = session.createRelationTypeService();
		MOIRelationType dependency = rts.getRTByPath("DRT.Dependency");;
		System.out.println("Dependency"+dependency);

		DRelationService drs = conn.createDRelationService();
		MOIDRelation doThisJob = new MOIDRelation(chen.getId(), programmer.getId(), dependency.getId());
		drs.create(doThisJob);
		conn.commit();
		System.out.println(222);*/

		/*
		 * MOIModel region = mas.getModelByPath("HR.Country");
		 * 
		 * List<MOIData> regions = ds.getDatas(region.getId()); MOIData peking = null;
		 * for (MOIData region1 : regions) { System.out.println(region1.getName()); if
		 * (region1.getName().equals("China")) { peking = region1; break; } continue; }
		 * 
		 * System.out.println(peking);
		 * 
		 * if (peking != null) { String firstName = (String)
		 * peking.getAttribute("Region_Name");
		 * 
		 * System.out.println(firstName); }
		 */

		/*
		 * MOIModel region = mas.getModelByPath("HR.Employee");
		 * 
		 * List<MOIData> regions = ds.getDatas(region.getId()); MOIData peking = null;
		 * for (MOIData region1 : regions) { System.out.println(region1.getName()); if
		 * (region1.getName().equals("chen")) { peking = region1; break; } continue; }
		 * 
		 * System.out.println(peking);
		 * 
		 * if (peking != null) { String firstName = (String)
		 * peking.getAttribute("Region_Name");
		 * 
		 * System.out.println(firstName); }
		 */

		MOIModel departmentModel = mas.getModelByPath("HR.Department");
		List<MOIData> departments = ds.getDatas(departmentModel.getId());
		MOIData peking = null;
		for (MOIData department : departments) {
			System.out.println(department);
			if (department.getName().equals("IT")) {
				peking = department;
				break;
		}
		continue;
		}
		System.out.println(peking);
		DRelationService drs = conn.createDRelationService();
		RelationTypeService rts = session.createRelationTypeService();
		MOIRelationType dependencyRT = rts.getRTByPath("DRT.Dependency");
		System.out.println(peking.getId());
		List<MOIDRelation> management = drs.getTargetDRelations(peking.getId(), dependencyRT.getId());
		System.out.println(management);
		for (int i = 0; i < management.size(); i++) {
			MOIData manager = (MOIData) ds.getData(management.get(i).getTargetDataId());
			System.out.println(manager.getName());
		} 

		/*if (peking != null) {
			MOIData employees = (MOIData) ds.getChildren(peking);
			for (MOIData employee : employees) {
				String firstName = (String) employee.getAttribute("First_Name");
				String lastName = (String) employee.getAttribute("Last_Name");
				String salary = (String) employee.getAttribute("Salary");
			
				System.out.println(firstName + "" + lastName + ":" +salary);
		}
		}*/

	}

}
