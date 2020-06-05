public class maxBipartiteMatching {
    // A DFS based recursive function
    // that returns true if a matching
    // for vertex u is possible
    boolean bpm(boolean bpGraph[][], int u,int N,
             boolean seen[], int matchR[])
    {
        // Try every job one by one
        for (int v = 0; v < N; v++)
        {
            // If applicant u is interested in
            // job v and v is not visited
            if (bpGraph[u][v] && !seen[v])
            {
                // Mark v as visited
                seen[v] = true;

                // If job 'v' is not assigned to an
                // applicant OR previously assigned
                // applicant for job v (which is matchR[v])
                // has an alternate job available.
                // Since v is marked as visited in
                // the above line, matchR[v] in the following
                // recursive call will not get job 'v' again
                if (matchR[v] < 0 || bpm(bpGraph, matchR[v],
                        N, seen, matchR))
                {
                    matchR[v] = u;
                    return true;
                }
            }
        }
        return false;
    }
}
