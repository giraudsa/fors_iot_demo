package JavaServer;
import java.util.*;
import fors.objectsManagement.*;
/*BEGIN_USERHEADER*/
/*END_USERHEADER*/


public class Historique implements ManagedObject
/*BEGIN_USERINTERFACE*/
/*END_USERINTERFACE*/
{
	private boolean __createdBySPC = false;
	public boolean __getCreatedBySPC() {return __createdBySPC;}
	public void __setCreatedBySPC(boolean bySPC) {__createdBySPC=bySPC;}
	protected static final ObjectManager _om = Application._om;
	protected final static ClassDesc __classDesc = _om.getClassDesc("Historique");
	public ClassDesc getClassDesc() { return __classDesc; }

	public Object $call(String methodName, Map<String,Object> argsMap, JsonServerRequest request) throws Exception{
		throw new NoSuchMethodException(methodName);
	}

	public Historique() {
		_om.registerCreate(this, "Historique", null, false);
	}
	public Historique(String id) {
		_om.registerCreate(this, "Historique", id, false);
	}
	public Historique(String id, Boolean newFromOtherServer) {
		_om.registerCreate(this, "Historique", id, newFromOtherServer);
	}

	public boolean canDelete() {return true;}
	public void delete() {
		_om.registerDelete(getId(),"Historique");
	}
	public void reset() {
	}
	public Object __get(String attPath) {
		return __get(attPath, null);
	}
	public Object __get(String attPath, Object defaultIfNull) {
		return _om.get(this, attPath, defaultIfNull);
		//return _om.get("Historique", getId(), attName);
	}
	public boolean __set(String slotName, Object value) throws Exception {
		return _om.set(this, "Historique", getId(), slotName, value);
	}
	public boolean __reset(String slotName) {
		return _om.reset(this, "Historique", getId(), slotName);
	}
	public void __addTo(String slotName, ManagedObject obj) throws Exception {
		_om.addTo(this, "Historique", getId(), slotName, obj);
	}
	public void __removeFrom(String slotName, ManagedObject obj) {
		_om.removeFrom(this, "Historique", getId(), slotName, obj);
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
	public static Collection<Historique> getAllHistorique() {
		Collection<Historique> vals = _om.getAll(Historique.class);
			if (vals != null) {
				ArrayList<Historique> list = new ArrayList<Historique>(vals);
				Collections.sort(list, new Comparator<Historique>() {
					public int compare(Historique a,Historique b) {
						if( a == null && b ==null) return 0;
						if( a == null) return -1;
						if( b == null) return +1;
						Date sa = a.getTimestamp();
						Date sb = b.getTimestamp();
						if( sa == null && sb ==null) return 0;
						if( sa == null) return -1;
						if( sb == null) return 1;
						return sa.compareTo(sb);
					}
				});
				return Collections.unmodifiableList(list);
			}
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
	}

	public Double getAlpha() {
		return (Double)__get("alpha");
	}
	public boolean setAlpha(Double value) throws Exception { return __set("alpha",value); }
	public Double getBeta() {
		return (Double)__get("beta");
	}
	public boolean setBeta(Double value) throws Exception { return __set("beta",value); }
	public Date getTimestamp() {
		return (Date)__get("timestamp");
	}
	public boolean setTimestamp(Date value) throws Exception { return __set("timestamp",value); }
/*BEGIN_USERBODY*/
/*END_USERBODY*/
}
