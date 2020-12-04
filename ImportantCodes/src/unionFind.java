import java.util.*;

public class unionFind {

    int nCn; // number of component
    int size; // number of elements in this disjointset
    int[] sizeCcs; // size of each cc
    int[] label; // assignment
    unionFind(int size) {
        if(size <= 0) throw new IllegalArgumentException("size <= 0 is not allowed.");
        this.size = size;
        nCn = size; // num of cc is num of nodes
        sizeCcs = new int[size];
        Arrays.fill(sizeCcs, 1); // at first, node itself
        label = new int[size];
        for(int i = 0; i < size; label[i] = i, i++); // at first each assigned to itself
    }
    int find(int v) { // find the root of each node
        if(label[v] != v) // label of root is itself
            return label[v] = find(label[v]); // path compression
        else return v;
    }
    // wrong!!! void unify(int u, int v) {
    //    label[find(u)] = label[find(v)]; -> label[] = find()
    //}
    void unify_opt(int u, int v) {
        int uf = find(u);
        int vf = find(v);
        if(uf == vf) return;

        if(sizeCcs[uf] > sizeCcs[vf]) {
            sizeCcs[uf] += sizeCcs[vf];
            label[vf] = uf;
        } else {
            sizeCcs[vf] += sizeCcs[uf];
            label[uf] = vf;
        }
        nCn--;
    }
    boolean isConnected(int u, int v) {
        return find(u) == find(v);
    }
    int componentSize(int v) {
        return sizeCcs[find(v)];
    }

}
