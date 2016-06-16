package p1;

import java.util.*;

public class entrance {
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int x=0;x<t;x++)
		{
			int x1=0;
			int n = in.nextInt();
			int k = in.nextInt();
			int e = in.nextInt();
			int m = in.nextInt();
			if (k==n)
			{
				System.out.println(x1);
				continue;
			}
			ArrayList<Long> a1 = new ArrayList<Long>();
			for (int i=0;i<n-1;i++)
			{
				long count=0;
				for(int j=0;j<e;j++)
					count += in.nextInt();
				a1.add(count);
			}
			long cmark = 0;
			for(int i=0;i<e-1;i++)
				cmark+=in.nextInt();
			
			Collections.sort(a1);
			long rmark = a1.get(n-k-1);
			
			if(cmark>rmark)
				System.out.println(x1);
			else if (rmark+1-cmark<=m)
				System.out.println(rmark-cmark+1);
			else
				System.out.println("Impossible");
		}
	}

}
