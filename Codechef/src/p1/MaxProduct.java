package p1;

import java.util.*;

public class MaxProduct {
	static long MOD = (long) (Math.pow(10,9) + 7);
	
	static MaxProduct ab = new MaxProduct();
	
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		for(int x1=0;x1<t;x1++)
		{
			int n=in.nextInt(), k =in.nextInt();
			ArrayList<Pair<Integer, Integer>> a1 = new ArrayList<Pair<Integer, Integer>>();
			for(int i=0;i<n;i++)
			{
				int temp = in.nextInt();
				int flag = 1;
				if(temp<0)
					flag=-1;
				Pair<Integer, Integer> p1 = ab.new Pair<Integer, Integer>(Math.abs(temp), flag);
				a1.add(p1);
			}
			Collections.sort(a1, Comparator.comparing(p -> p.getL()));
			int count=0;
			for(int i=n-1;i>=n-k;i--)
			{
				Pair<Integer, Integer> p1 = a1.get(i);
				if (p1.getR()==-1)
					count++;
			}
			if (count%2==0)
			{
				long ans=1;
				for(int i=n-1;i>=n-k;i--)
				{
					Pair<Integer, Integer> p1 = a1.get(i);
					ans = ((ans%MOD)*(p1.getL()%MOD))%MOD;
				}
				System.out.println(ans);
				continue;
			}
			else
			{
				int ni = Integer.MAX_VALUE;
				int mini = -1;
				int pini = -1;
				int pi = Integer.MAX_VALUE;
				for(int i=n-1;i>=n-k;i--)
				{
					Pair<Integer, Integer> p1 = a1.get(i);
					if(p1.getL()<ni&&p1.getR()==-1)
					{
						ni=p1.getL();
						mini=i;
					}
					if(p1.getL()<pi&&p1.getR()==1)
					{
						pi=p1.getL();
						pini=-1;						
					}
				}
				int no = Integer.MIN_VALUE;
				int moni = -1;
				int poni = -1;
				int po = Integer.MIN_VALUE;
				for(int i=0;i<n-k;i++)
				{
					Pair<Integer, Integer> p1 = a1.get(i);
					if(p1.getL()<no&&p1.getR()==-1)
					{
						no=p1.getL();
						moni=i;
					}
					if(p1.getL()<po&&p1.getR()==1)
					{
						po=p1.getL();
						poni=-1;						
					}
				}
				if(mini!=-1&&pini!=-1&&moni!=-1&&poni!=-1)
				{
					long ans1=1;
					for(int i=n-1;i>=n-k&&i!=pini;i--)
					{
						Pair<Integer, Integer> p1 = a1.get(i);
						ans1 = (ans1%MOD)*(p1.getL()%MOD);
					}
					ans1 = ((ans1%MOD)*(no%MOD))%MOD;
					
					long ans2=1;
					for(int i=n-1;i>=n-k&&i!=mini;i--)
					{
						Pair<Integer, Integer> p1 = a1.get(i);
						ans2 = (ans2%MOD)*(p1.getL()%MOD);
					}
					ans2 = ((ans2%MOD)*(po%MOD))%MOD;
					
					long ans = Math.max(ans1, ans2);
					System.out.println(ans);
					continue;
				}
				else if (pini!=-1&&moni!=-1)
				{
					long ans=1;
					for(int i=n-1;i>=n-k&&i!=pini;i--)
					{
						Pair<Integer, Integer> p1 = a1.get(i);
						ans = (ans%MOD)*(p1.getL()%MOD);
					}
					ans = ((ans%MOD)*(no%MOD))%MOD;
					System.out.println(ans);
					continue;
				}
				else if (poni!=-1&&mini!=-1)
				{
					long ans=1;
					for(int i=n-1;i>=n-k&&i!=mini;i--)
					{
						Pair<Integer, Integer> p1 = a1.get(i);
						ans = (ans%MOD)*(p1.getL()%MOD);
					}
					ans = ((ans%MOD)*(po%MOD))%MOD;
					System.out.println(ans);
					continue;
				}
				else
				{
					long ans=1;
					for(int i=0;i<k;i++)
					{
						Pair<Integer, Integer> p1 = a1.get(i);
						ans = ((ans%MOD)*(p1.getL()%MOD))%MOD;
					}
					ans = 0 - ans;
					ans = ans%MOD;
					ans = MOD+ans;
					System.out.println(ans);
					continue;
				}
			}
		}
	}
	
	class Pair<L,R>{
		private L l;
		private R r;
		public Pair(L l, R r){
			this.l = l;
			this.r = r;
		}
		public L getL(){ return l; }
		public R getR(){ return r; }
		public void setL(L l){ this.l = l; }
		public void setR(R r){ this.r = r; }
	}
}
