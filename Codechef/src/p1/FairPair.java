package p1;
import java.util.*;
public class FairPair {
	
	static ArrayList<Integer> t1 = new ArrayList<Integer>();
	static HashMap<Integer,HashMap<ArrayList<Integer>,Integer>> h11 = new HashMap<Integer,HashMap<ArrayList<Integer>,Integer>>();
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		
		for(int x1=0;x1<t;x1++)
		{
			int n = in.nextInt();
			ArrayList<Integer> S = new ArrayList<Integer>();
			ArrayList<Integer> T = new ArrayList<Integer>();
			
			for(int i=0;i<n;i++)
				S.add(in.nextInt());

			for(int i=0;i<n;i++)
				T.add(in.nextInt());
			
			ArrayList<ArrayList<Integer>> mem = new ArrayList<ArrayList<Integer>>();
			
			for(int i=0;i<n;i++)
			{
				ArrayList<Integer> temp = new ArrayList<Integer>();
				for(int j=0;j<n;j++)
					temp.add(-1);
				mem.add(temp);
			}
			for(int i=n-1;i>+0;i--)
			{
				if (i==n-1)
				{
					for(int j=0;j<n;j++)
					{
						if(T.get(j)==S.get(i))
							mem.get(i).set(j,1);
						else
							mem.get(i).set(j,0);
					}
				}
				else
				{
					for(int j=0;j<n;j++)
					{
						int min=Integer.MAX_VALUE;
						for(int k=0;k<n&&k!=j;k++)
						{
							if(min>mem.get(i+1).get(k))
								min = mem.get(i+1).get(k);
						}
						if(T.get(j)==S.get(i))
						{
							mem.get(i).set(j, min+1);
						}
						else
							mem.get(i).set(j,min);						
							
					}
				}
			}
			int minn = Integer.MAX_VALUE;
			for(int i=0;i<n;i++)
				if(minn>mem.get(0).get(i))
					minn=mem.get(0).get(i);
			
			System.out.println(minn);
		}
	}
	
	public static int min(int index, ArrayList<Integer> S, ArrayList<Integer> T, ArrayList<Integer> assign)
	{
		if (index==S.size())
		{
			int count=0;
			for(int i=0;i<S.size();i++)
				if(T.get(assign.get(i))==S.get(i))
					count++;
			t1 = assign;
			return count;
		}
		int min2 = Integer.MAX_VALUE;
		for(int i=0;i<T.size();i++)
		{
			if (!assign.contains(i))
			{
				ArrayList<Integer> a1 = new ArrayList<Integer>(assign);
				a1.add(i);
				int val = min(index+1,S,T,a1);
				if (val<min2)
					min2 = val;
			}
		}
		return min2;
	}

}
