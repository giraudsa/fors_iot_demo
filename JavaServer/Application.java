package JavaServer;
import java.util.*;
import fors.objectsManagement.*;
/*BEGIN_USERHEADER*/
/*END_USERHEADER*/


public class Application implements ManagedObject
/*BEGIN_USERINTERFACE*/
/*END_USERINTERFACE*/
{
	private boolean __createdBySPC = false;
	public boolean __getCreatedBySPC() {return __createdBySPC;}
	public void __setCreatedBySPC(boolean bySPC) {__createdBySPC=bySPC;}
	public static ObjectManager _om = null;
	protected static ClassDesc __classDesc = null;
	public ClassDesc getClassDesc() { return __classDesc; }

	public Object $call(String methodName, Map<String,Object> argsMap, JsonServerRequest request) throws Exception{
		if ("deleteTelephone".equals(methodName)) {
			deleteTelephone(argsMap, request);
			return null;
		}
		if ("getOrCreateTelephone".equals(methodName)) {
			return	getOrCreateTelephone(argsMap, request);
		}
		throw new NoSuchMethodException(methodName);
	}


	//public static String rootSaveDirectory = "SAEData";
	private static Application instance = null;

	public static Application getInstance(Map<String,String> argsMap) {
		if ( instance == null && argsMap !=null ) {
			if ( argsMap.get("-d") == null ) argsMap.put("-d","SAEData");
			_om = ObjectManager.getInstance(Application.class.getPackage().getName(), "JavaServer", argsMap);
			__classDesc = _om.getClassDesc("Application");
			instance = new Application("Application_1");
			_om.init(argsMap, instance);
		}
		return instance;
	}
	public static void main(String[] args) {
		HashMap<String,String> argsMap = new HashMap<String,String>();
		for (int i=0; i<args.length;i+=2) {
			if (i+1 < args.length) argsMap.put(args[i], args[i+1]);
		}
		Application app = getInstance(argsMap);
		try { WebServer.init(app, _om, argsMap); } catch (Exception e) {e.printStackTrace();}
	}

	public Application() {
		_om.registerCreate(this, "Application", null, false);
	}
	public Application(String id) {
		_om.registerCreate(this, "Application", id, false);
	}
	public Application(String id, Boolean newFromOtherServer) {
		_om.registerCreate(this, "Application", id, newFromOtherServer);
	}

	public boolean canDelete() {return true;}
	public void delete() {
		Set<Telephone> objs_Telephones = ((Set<Telephone>)__get("telephones"));
		if ( objs_Telephones != null) {
			Iterator<Telephone> iterTelephones = objs_Telephones.iterator();
			while (iterTelephones.hasNext()) {
				Telephone obj = iterTelephones.next();
				iterTelephones.remove();
				obj.delete();
			}
		}
		_om.registerDelete(getId(),"Application");
	}
	public void reset() {
		Set<Telephone> objs_Telephones = ((Set<Telephone>)__get("telephones"));
		if ( objs_Telephones != null) {
			Iterator<Telephone> iterTelephones = objs_Telephones.iterator();
			while (iterTelephones.hasNext()) {
				Telephone obj = iterTelephones.next();
				iterTelephones.remove();
				obj.delete();
			}
		}
	}
	public Object __get(String attPath) {
		return __get(attPath, null);
	}
	public Object __get(String attPath, Object defaultIfNull) {
		return _om.get(this, attPath, defaultIfNull);
		//return _om.get("Application", getId(), attName);
	}
	public boolean __set(String slotName, Object value) throws Exception {
		return _om.set(this, "Application", getId(), slotName, value);
	}
	public boolean __reset(String slotName) {
		return _om.reset(this, "Application", getId(), slotName);
	}
	public void __addTo(String slotName, ManagedObject obj) throws Exception {
		_om.addTo(this, "Application", getId(), slotName, obj);
	}
	public void __removeFrom(String slotName, ManagedObject obj) {
		_om.removeFrom(this, "Application", getId(), slotName, obj);
	}
	public Object __getShared(String attName) {
		return _om.getShared(this,attName);
	}
	public void __setShared(String attName, Object val) {
		_om.setShared(this, attName, val);
	}
	public void __addToShared(String relName, ManagedObject val) {
		_om.addToShared(this, relName, val);
	}
	public void __removeFromShared(String relName, ManagedObject val) {
		_om.removeFromShared(this, relName, val);
	}
	public static Collection<Application> getAllApplication() {
		Collection<Application> vals = _om.getAll(Application.class);
		return vals;
	}

	protected String __id = "";
	public String getId() { return __id; }
	public void setId(String id) { this.__id = id; }
	protected int __status = EMPTY;
	public int get_status() { return __status; }
	public void set_status(int status) {
		this.__status = status;
	}

	public Map<String,Map<Object,ManagedObject>> $indexes = new LinkedHashMap<String,Map<Object,ManagedObject>>();
	private boolean isInIndexesList(String indexName, Collection<String> indexesNames) {
		if (indexesNames == null)return true;
		return indexesNames.contains(indexName);
	}
	public Map<String,Map<Object,ManagedObject>> getIndexes() { return $indexes; }
	public Map<Object,ManagedObject> getIndexMap(String relation) {
		Map<Object,ManagedObject> map = $indexes.get(relation);
		if (map == null) {
			map = new LinkedHashMap<Object,ManagedObject>();
			$indexes.put(relation,map);
		}
		return map;
	}
	public void rebuildIndexes(Collection<String> indexesNames) {
		Map<Object,ManagedObject> indexMap=null;
		if (isInIndexesList("telephonesBynom",indexesNames)) {
			indexMap = $indexes.get("telephonesBynom");
			if (indexMap==null) {
				indexMap = new LinkedHashMap<Object,ManagedObject>();
				$indexes.put("telephonesBynom",indexMap);
			} else {
				indexMap.clear();
			}
			for(Telephone obj : (Set<Telephone>)__getShared("telephones")) {
				indexMap.put(obj.__getShared("nom"),obj);
			}
		}
	}

	public Collection<Telephone> getTelephones() {
		Set<Telephone> vals = (Set<Telephone>)_om.getTransaction().getValues(getId(),"telephones",(Set<Telephone>)__getShared("telephones"));
			if (vals != null) {
				ArrayList<Telephone> list = new ArrayList<Telephone>(vals);
				Collections.sort(list, new Comparator<Telephone>() {
					public int compare(Telephone a,Telephone b) {
						if( a == null && b ==null) return 0;
						if( a == null) return -1;
						if( b == null) return +1;
						String sa = a.getNom();
						String sb = b.getNom();
						if( sa == null && sb ==null) return 0;
						if( sa == null) return -1;
						if( sb == null) return 1;
						return sa.compareToIgnoreCase( sb);
					}
				});
				return Collections.unmodifiableList(list);
			}
		return vals;
	}
	public void addToTelephones(ManagedObject obj) throws Exception {
		__addTo("telephones", obj);
	}
	public void removeFromTelephones(ManagedObject obj) {
		__removeFrom("telephones", obj);
	}
	public void resetTelephones() {
		__reset("telephones");
	}
	public boolean telephonesByNomContainsKey(Object index) {
		return _om.getTransaction().indexedRelationContainsKey(getId(), "telephonesBynom", index, getIndexMap("telephonesBynom"));
	}
	public Set<Object> getTelephonesByNomKeys() {
		return _om.getTransaction().getIndexedRelationKeys(getId(), "telephonesBynom", getIndexMap("telephonesBynom"));
	}
	public Telephone getTelephonesByNom(Object index) {
		return (Telephone)_om.getTransaction().getIndexedRelationValue(getId(), "telephonesBynom", index, getIndexMap("telephonesBynom"));
	}

//	private void deleteTelephone(Map<String, Object> argsMap, JsonServerRequest request) throws Exception {}
//	private Telephone getOrCreateTelephone(Map<String, Object> argsMap, JsonServerRequest request) throws Exception {}
/*BEGIN_USERBODY*/
	private void deleteTelephone(Map<String, Object> argsMap, JsonServerRequest request) throws Exception {}
	private Telephone getOrCreateTelephone(Map<String, Object> argsMap, JsonServerRequest request) throws Exception {
		String nom = (String)argsMap.get("nom");
		Telephone telephone = getTelephonesByNom(nom);
		if(telephone == null){
			System.out.println("creation du téléphone" + nom);
			telephone = new Telephone(nom, false, 0.0, 0.0);
			addToTelephones(telephone);
		}
		_om.commit();
		return telephone;
	}
/*END_USERBODY*/
}
