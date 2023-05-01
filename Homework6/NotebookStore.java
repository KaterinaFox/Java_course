import java.util.HashMap;
import java.util.Map;

public class NotebookStore {
    private HashMap<Notebook, Long> store = new HashMap<Notebook, Long>();

    public long add(Notebook notebook) {
        return this.add(notebook, 1L);
    }
    public long add(Notebook notebook, long amount) {
        long count;
        if (!store.containsKey(notebook)) {
            store.put(notebook, amount);
            count = 1;
        } else {
            count = store.get(notebook) + amount;
            store.put(notebook, count);
        }
        return count;
    }
    public NotebookStore filter(Notebook notebook) {
        NotebookStore result = new NotebookStore();
        for (Map.Entry<Notebook, Long> entry : store.entrySet()) {
            Notebook find_notebook = entry.getKey();
            long count = entry.getValue();
            if (find_notebook.isSuite(notebook)) {
                result.add(find_notebook, count);
            }
        }
        return result;
    }

    public boolean isEmpty() {
        return store.isEmpty();
    }

    public HashMap<Notebook, Long> get_store() {
        return store;
    }
}
