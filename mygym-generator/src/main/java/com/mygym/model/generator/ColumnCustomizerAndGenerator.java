package com.mygym.model.generator;

import com.netu.codeGen.XMLClassGenerator2;
import com.netu.codeGen.XMLModelGenerator;
import com.netu.lib.IOUtils;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codegen.db.DBField;
import org.codegen.generator.CodeGenerator;
import org.codegen.iface.IColumnCustomizer;
import org.codegen.iface.IField;
import org.codegen.iface.IObjectToGenerate;
import org.codegen.iface.ITable;
import org.json.JSONObject;

/**
 * com.mygym.model.generator.ColumnCustomizerAndGenerator
 * @author christoforosl
 */
public class ColumnCustomizerAndGenerator implements IColumnCustomizer {
	
	private final String AUDIT_FIELDS_ON_LIST_PAGE = "<td data-title=\"'Created On'\" filter=\"{createDate : 'text'}\" sortable=\"'createDate'\">{{ row.createDate| date: 'd MMM yyyy HH:mm'  }}</td>\r\n" +
"<td data-title=\"'Created By'\" filter=\"{createUser : 'text'}\" sortable=\"'createUser'\">{{ row.createUser}}</td>\r\n" +
"<td data-title=\"'Updated On'\" filter=\"{updateDate : 'text'}\" sortable=\"'updateDate'\">{{ row.updateDate| date: 'd MMM yyyy HH:mm'  }}</td>\r\n" +
"<td data-title=\"'Updated By'\" filter=\"{updateUser : 'text'}\" sortable=\"'updateUser'\">{{ row.updateUser}}</td>\r\n";

	
	private static final String stateTemplate = "states.sponsorState = {\n\tname: 'root.sponsor',\n" +
		"\turl: '/sponsor',\r\n" +
		"\ttemplateUrl: 'components/sponsor/pages/sponsorList.html',\r\n" +
		"\tdata: {\r\n" +
		"\t\tauthorizedRoles: [],\r\n" +
		"\t\tauthorizedFunctions: []\r\n" +
		"\t}\r\n" +
		"\t};\r\n";
		
	
	private static final String LIST_HTML = "<div-content ctitle='Sponsor' show-add-button=\"true\">\r\n" +
"	<div ng-controller=\"sponsorListController as vm\" >\r\n" +
"	<div class=\"panel panel-default\">\r\n" +
"		<div class=\"panel-body\">\r\n" +
"			<button id=\"btnAddNew\" type=\"button\" class=\"btn btn-success\" ng-click=\"vm.addRow()\" title=\"Add New Row\" >\r\n" +
"				<i class=\"glyphicon glyphicon-plus\"></i> &nbsp; Add New\r\n" +
"			</button>\r\n" +
"		</div>\r\n" +
"	</div>\r\n" +
"	\r\n" +
"		<div style=\"overflow:auto\">\r\n" +
"        <table ng-table=\"vm.sponsorData\" class=\"table col-md-6\" show-filter=\"vm.showFilter\">\r\n" +
"			<tr ng-repeat=\"row in $data\" ng-form=\"rowForm\">\r\n<tfields>" +
"			</tr>\r\n" +
"		</table>\r\n" +
"	</div>		\r\n" +
"    </div>\r\n" +
"</div-content>\r\n";
	
 // BuildMyString.com generated code. Please enjoy your string responsibly.
		private static final String JS_EDIT_CTRLR_CODE = "/* global iapApp, BaseEditController */\r\n" +
		"iapApp.controller('sponsorController', [ '$uibModalInstance', 'row', '$scope','$injector','nuafSeedService',\r\n" +
		"	function (  $uibModalInstance, row, $scope, $injector, nuafSeedService) {\r\n" +
		"	var vm = this;\r\n" +
		"	BaseEditController.call(this, $scope, $injector, $uibModalInstance);\r\n" +
		"	\r\n" +
		"	vm.entityName = '<entityname>';\r\n" +
		"	vm.formlyModel = row; // important! keep this after CRUD init\r\n" +
		"	nuafSeedService.loadSeeds('').then(function(seeds){\r\n" +
		"		vm.formlyFields = [\r\n" +
		"<fields>"+
		"		];\r\n" +
		"	});\r\n" +
		"}]);\r\n";

		private static final String JS_LIST_CTRLR_CODE = "/* global iapApp, sponsorController, _ */\r\n" +
"iapApp.controller('sponsorListController', ['editUIService', '$scope', 'nuafSeedService','NgTableParams', 'nuafCRUDService', \r\n" +
"		function (editUIService,  $scope, nuafSeedService, NgTableParams,nuafCRUDService) {\r\n" +
"	var vm = this;\r\n" +
"	var entityType = 'sponsor';\r\n" +
"	vm.sponsorData = new NgTableParams( {sorting: { updateDate: \"desc\" }} );\r\n" +
"	 nuafCRUDService.query(entityType).then(function (response) {\r\n" +
"		vm.sponsorData.settings({ dataset: response });\r\n" +
"	});\r\n" +
"	\r\n" +
"	vm.deleteRow = function(row) {\r\n" +
"		editUIService.uiDelete(entityType,row,vm.sponsorData);\r\n" +
"		nuafSeedService.deleteSeeds('sponsors');\r\n" +
"	};\r\n" +
"	\r\n" +
"	vm.addRow = function() {\r\n" +
"		editUIService.uiModifyRowModal(entityType,{\"new\":true, \"id\": $scope.getNextId()},vm.sponsorData);\r\n" +
"	};\r\n" +
"	\r\n" +
"	vm.modifyRow = function(row) {\r\n" +
"		editUIService.uiModifyRowModal(entityType,row,vm.sponsorData);\r\n" +
"	};\r\n" +
"	\r\n" +
"}]);\r\n";

	private static final JSONObject FORMLY_FIELD =  new JSONObject("{\"key\": \"key\",\"type\": \"input\",\"templateOptions\": {\"label\": \"Label\",\"required\": false}}");
	
	public static void main(String[] args) throws Exception {
		
		XMLClassGenerator2 x = new XMLClassGenerator2();
		
		x.genClassesFromResourceFile("generator.xml");
		
	}
	
	private static final Logger logger = Logger.getLogger(ColumnCustomizerAndGenerator.class.getName());
			
	@Override
	public void handleColumns(ITable t, List fieldList) {
		final XMLModelGenerator genr = (XMLModelGenerator) CodeGenerator.current();
		final String tname = t.getTableName().toLowerCase();
		final String gentable = "";
		// do not comment out this code
		if(! genr.getJsonAnnotationImports().equals(XMLModelGenerator.JsonAnnotation.FASTER_XML)) {
			genr.setJsonAnnotationImports(XMLModelGenerator.JsonAnnotation.FASTER_XML);
		}
		
		StringBuilder sbld = new  StringBuilder();
		StringBuilder tfields = new  StringBuilder();
		
		fieldList.stream().forEach((Object o) -> {
			DBField f = (DBField) o;
			final List<IObjectToGenerate> objectsToGenerateOfTable = CodeGenerator.current().getObjectsToGenerateOfTable(t.getTableName());
			if (f.getFieldName().toLowerCase().endsWith("url_id")) {
				logger.log(Level.FINE, String.format("!!!!!!! found IURLIndetified: %s", t.getTableName()));

				objectsToGenerateOfTable.forEach((IObjectToGenerate og) -> {
					og.addModelInterface("com.treegoat.marbyl.model.IURLIndetified");
				});
			}
			
			if ( tname.equalsIgnoreCase(gentable) && ! f.isAuditField()) {
				
				String jsonName = Character.toLowerCase(f.getJavaFieldName().charAt(0)) + f.getJavaFieldName().substring(1);
				
				JSONObject jsn2 = new JSONObject(FORMLY_FIELD.toString());
				jsn2.put("key", f.getJavaFieldName());
				((JSONObject)jsn2.get("templateOptions")).put("label", f.getJavaFieldName());
				((JSONObject)jsn2.get("templateOptions")).put("required", !f.isAllowNulls());
				sbld.append("\t\t\t");
				sbld.append(jsn2.toString());
				sbld.append(",\n");
				
				tfields.append( getTableField(f) );	
			}
		});
		
		if ( tname.equalsIgnoreCase(gentable) ) {
			
			final String javaName = Character.toLowerCase(t.getGeneratedClassName().charAt(0)) + t.getGeneratedClassName().substring(1); ;
			
			try {
				File dir = new File("../marbyl-admin-web/src/components/"+ javaName);
				dir.mkdirs();
				File dir2 = new File("../marbyl-admin-web/src/components/"+ javaName + "/pages");
				dir2.mkdirs();
				
				final String editController = JS_EDIT_CTRLR_CODE.replace("<entityname>", javaName).replace("<fields>",sbld.toString() );
				IOUtils.writeFile(dir.getAbsolutePath()+"/" + javaName + "Controller.js",editController, "UTF-8");

				final String listController = JS_LIST_CTRLR_CODE.replace("sponsor", javaName );
				IOUtils.writeFile(dir.getAbsolutePath() + "/" + javaName + "ListController.js",listController, "UTF-8");
				String tname2 = Character.toUpperCase(javaName.charAt(0)) + javaName.substring(1);
				
				tfields.append(AUDIT_FIELDS_ON_LIST_PAGE);
				
				final String listHTML = LIST_HTML.replace("sponsor", javaName ).replace("Sponsor", tname2 ).replace("<tfields>", tfields.toString() );
				IOUtils.writeFile(dir2.getAbsolutePath() + "/" +  javaName + "List.html",listHTML, "UTF-8");

				System.out.println("-------");
				System.out.println("add this to app.config.router:");
				System.out.println(stateTemplate.replace("sponsor", javaName ));
				System.out.println("-------");
				System.out.println("---also add link to nav.html");
				

			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}


		}

	}
	
	private String getTableField( DBField f ) {
		String jsonName = Character.toLowerCase(f.getJavaFieldName().charAt(0)) + f.getJavaFieldName().substring(1);
		String sb = "<td data-title=\"'" + f.getFieldName()+  "'\" filter=\"{"+jsonName+" : 'text'}\" sortable=\"'"+jsonName+"'\">{{ row."+jsonName+"  }}</td>\r\n" ;
		return sb;
	}
	
	@Override
	public void jspHandleField(ITable t, IField f) {
		
	}

	@Override
	public String jspHandleCode(ITable t, IField f, String generatedCode) {
		return generatedCode;
	}
	
}
