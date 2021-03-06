package JavaServer;
import java.util.*;
import fors.objectsManagement.*;
/*BEGIN_USERHEADER*/
import java.util.concurrent.TimeUnit;
/*END_USERHEADER*/


public class Telephone implements ManagedObject
/*BEGIN_USERINTERFACE*/
/*END_USERINTERFACE*/
{
	private boolean __createdBySPC = false;
	public boolean __getCreatedBySPC() {return __createdBySPC;}
	public void __setCreatedBySPC(boolean bySPC) {__createdBySPC=bySPC;}
	protected static final ObjectManager _om = Application._om;
	protected final static ClassDesc __classDesc = _om.getClassDesc("Telephone");
	public ClassDesc getClassDesc() { return __classDesc; }

	public Object $call(String methodName, Map<String,Object> argsMap, JsonServerRequest request) throws Exception{
		throw new NoSuchMethodException(methodName);
	}

	public Telephone() {
		_om.registerCreate(this, "Telephone", null, false);
	}
	public Telephone(String id) {
		_om.registerCreate(this, "Telephone", id, false);
	}
	public Telephone(String id, Boolean newFromOtherServer) {
		_om.registerCreate(this, "Telephone", id, newFromOtherServer);
	}

	public boolean canDelete() {return true;}
	public void delete() {
		__reset("application");
		Set<Historique> objs_Historiques = ((Set<Historique>)__get("historiques"));
		if ( objs_Historiques != null) {
			Iterator<Historique> iterHistoriques = objs_Historiques.iterator();
			while (iterHistoriques.hasNext()) {
				Historique obj = iterHistoriques.next();
				iterHistoriques.remove();
				obj.delete();
			}
		}
		_om.registerDelete(getId(),"Telephone");
	}
	public void reset() {
		__reset("application");
		Set<Historique> objs_Historiques = ((Set<Historique>)__get("historiques"));
		if ( objs_Historiques != null) {
			Iterator<Historique> iterHistoriques = objs_Historiques.iterator();
			while (iterHistoriques.hasNext()) {
				Historique obj = iterHistoriques.next();
				iterHistoriques.remove();
				obj.delete();
			}
		}
	}
	public Object __get(String attPath) {
		return __get(attPath, null);
	}
	public Object __get(String attPath, Object defaultIfNull) {
		return _om.get(this, attPath, defaultIfNull);
		//return _om.get("Telephone", getId(), attName);
	}
	public boolean __set(String slotName, Object value) throws Exception {
		return _om.set(this, "Telephone", getId(), slotName, value);
	}
	public boolean __reset(String slotName) {
		return _om.reset(this, "Telephone", getId(), slotName);
	}
	public void __addTo(String slotName, ManagedObject obj) throws Exception {
		_om.addTo(this, "Telephone", getId(), slotName, obj);
	}
	public void __removeFrom(String slotName, ManagedObject obj) {
		_om.removeFrom(this, "Telephone", getId(), slotName, obj);
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
	public static Collection<Telephone> getAllTelephone() {
		Collection<Telephone> vals = _om.getAll(Telephone.class);
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
	public String getNom() {
		return (String)__get("nom");
	}
	public boolean setNom(String value) throws Exception { return __set("nom",value); }
	public Boolean getVibre() {
		return (Boolean)__get("vibre");
	}
	public boolean setVibre(Boolean value) throws Exception { return __set("vibre",value); }

	public Application getApplication() {
		return (Application)__get("application");
	}
	public boolean setApplication(ManagedObject value) throws Exception {
		return __set("application", value);
	}
	public void resetApplication() {
		__reset("application");
	}

	public Collection<Historique> getHistoriques() {
		Set<Historique> vals = (Set<Historique>)_om.getTransaction().getValues(getId(),"historiques",(Set<Historique>)__getShared("historiques"));
			if (vals != null) {
				ArrayList<Historique> list = new ArrayList<Historique>(vals);
				Collections.sort(list, new Comparator<Historique>() {
					public int compare(Historique a,Historique b) {
						if( a == null && b ==null) return 0;
						if( a == null) return -1;
						if( b == null) return +1;
						Date da = a.getTimestamp();
						Date db = b.getTimestamp();
						return da.compareTo(db);
					}
				});
				return Collections.unmodifiableList(list);
			}
		return vals;
	}
	public void addToHistoriques(ManagedObject obj) throws Exception {
		__addTo("historiques", obj);
	}
	public void removeFromHistoriques(ManagedObject obj) {
		__removeFrom("historiques", obj);
	}
	public void resetHistoriques() {
		__reset("historiques");
	}

/*BEGIN_USERBODY*/

	private DataChangeObserver trigger;
	private Date lastChange = new Date(0);
	private final Object synchro = new Object();
	
	public DataChangeObserver getTrigger() {
		return trigger;
	}
	
	public void newTrigger() {
		this.trigger = new TriggerChange("telephone");
		trigger.execute();
	}

	public Telephone(String nom, boolean vibre, double alpha, double beta) throws Exception {
		this();
		this.setNom(nom);
		this.setVibre(vibre);
		this.setAlpha(alpha);
		this.setBeta(beta);
		newTrigger();
	}



	public class TriggerChange extends DataChangeObserver{


		public TriggerChange(String name) {
			super(name);
		}

		private long pasArchive = TimeUnit.MILLISECONDS.toMillis(500);
		private long tempsArchive = TimeUnit.MINUTES.toMillis(4);

		@Override
		public Object doTheJob(boolean isFirstCall) throws Exception {
			synchronized(synchro) {
				Log.debug("on rentre dans un datachange history sur telephone " + getNom());
				ArrayList<DataChangeObserver> toObserve = getterToObserve();
				Date now = new Date();
				if(now.getTime() - lastChange.getTime() > pasArchive) {
					lastChange = now;
					addToHistoriques(newHistorique(now));
					purgeHistoriqueDesVieuxEnregistrements(now);
				}
				_om.getTransaction().resumeTracking(toObserve);
				return null;
			}
		}

		private ArrayList<DataChangeObserver> getterToObserve() {
			getAlpha();
			getBeta();
			return _om.getTransaction().suspendTracking();
		}

		private void purgeHistoriqueDesVieuxEnregistrements(Date now) {
			Log.debug("suppression des vieux historiques de " + getNom());
			for(Historique histo : getHistoriques()) {
				if(now.getTime() - histo.getTimestamp().getTime() > tempsArchive) {
					Log.debug("on supprime un historique trop vieux");
					histo.delete();
				}else return;
			}
		}

		private Historique newHistorique(Date date) throws Exception {
			Log.debug("nouvel historique pour le téléphone " + getNom());
			Historique historique = new Historique();
			historique.setAlpha(getAlpha() == null ? 0.0 : getAlpha());
			historique.setBeta(getBeta() == null ? 0.0 : getBeta());
			historique.setTimestamp(date);
			return historique;
		}

		@Override
		public void doDelete() {
			trigger = null;
			super.doDelete();
		}

	}

/*END_USERBODY*/
}
