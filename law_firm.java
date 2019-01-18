package darwin;
import java.util.*;
public class law_firm {
    
    
    public static  class lawyer{
        static lawyer[] all=new lawyer[100000];
        static int cnt=0;
        static lawyer[] housing=new lawyer[10000];
        static lawyer[] family=new lawyer[100000];
        static lawyer[] finance=new lawyer[100000];
        static lawyer[] defmation=new lawyer[100000];
        static lawyer[] hash=new lawyer[10000000];
        static int housing_count=0;
        static int family_count=0;
        static int defmation_count=0;
        static int finance_count=0;
        client current;
        String category;
        String Name= " ";
        int lawyer_id;
        int pending=-2;
        client[] pendings=new client[10000];
        
        lawyer(String name , String category){
            this.category=category;
            this.Name=name;
            this.pending=-2;
            all[cnt]=this;
            
            cnt++;
            
            Random rand = new Random();
            lawyer_id = rand.nextInt(10000);
            hash[lawyer_id]=this;
            
            System.out.println(lawyer_id);
            if(category.equals("housing")) {
                housing[housing_count]=this;
                housing_count++;
            }
            else if(category.equals("defmation")) {
                defmation[defmation_count]=this;
                defmation_count++;
            }
            else if(category.equals("finance")) {
                finance[finance_count]=this;
                finance_count++;
                
            }
            else if(category.equals("family")) {
                family[family_count]=this;
                family_count++;
            }
            
            
        }
        
        
        
        public static client min_priority(lawyer advo) {
            client[] array=new client[10000];
            
            
            array=advo.pendings;
            
            
            int pen=advo.pending;
            
            int m=10;
            int gh=0;
            
            client retu=null;
            while(gh<pen) {
                System.out.print(gh);
                
                gh++;
                
                if(array[gh]==null) {break;}
                if(m>array[gh].priority) {
                    
                    
                    m=array[gh].priority;
                    retu=array[gh];
                }
            }
            
            advo.pending--;
            return (retu);
            
        }
    }
    public static lawyer min_pending(lawyer array[]) {
        int min=10000000;
        int j=0;
        
        lawyer retur=null;
        
        while(array[j]!=null) {
            
            if(array[j].pending<min) {
                min=array[j].pending;
                retur=array[j];
                
                
            }
            j++;
        }
        
        return (retur);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static class client{
        String name= " ";
        static client [] hash=new client[100000];;
        String category;
        int priority;
        int client_id;
        lawyer current ;
        lawyer pendingi;
        
        lawyer my_lawyer;
        client(String name,String category, int priority ){
            this.name=name;
            this.category=category;
            this.priority=priority;
            Random rand = new Random();
            client_id = rand.nextInt(1000);
            
            
            
            hash[client_id]=this;
            if(category.equals("housing")) {
                
                lawyer[] use=lawyer.housing;
                lawyer my_lawyer=min_pending(use);
                System.out.println(my_lawyer.Name);
                
                
                if(my_lawyer.pending==-2) {
                    
                    
                    my_lawyer.current=this;
                    
                    current=my_lawyer;
                    my_lawyer.pending=-1;
                    
                }
                else {
                    pendingi=my_lawyer;
                    
                    my_lawyer.pending++;
                    
                    
                    
                    my_lawyer.pendings[my_lawyer.pending]=this;
                    
                    
                }
                
                
                
            }
            else if(category.equals("defmation")) {
                lawyer[] use=lawyer.defmation;
                lawyer my_lawyer=min_pending(use);
                System.out.println(my_lawyer.Name);
                
                if(my_lawyer.pending==-2) {
                    
                    
                    my_lawyer.current=this;
                    
                    current=my_lawyer;
                    my_lawyer.pending=-1;
                    
                }
                else {
                    pendingi=my_lawyer;
                    
                    my_lawyer.pending++;
                    
                    my_lawyer.pendings[my_lawyer.pending]=this;
                    
                    
                }}
            
            
            else if(category.equals("finance")) {
                lawyer[] use=lawyer.finance;
                lawyer my_lawyer=min_pending(use);
                System.out.println(my_lawyer.Name);
                
                if(my_lawyer.pending==-2) {
                    
                    
                    my_lawyer.current=this;
                    
                    current=my_lawyer;
                    my_lawyer.pending=-1;
                    
                }
                else {
                    pendingi=my_lawyer;
                    
                    my_lawyer.pending++;
                    
                    my_lawyer.pendings[my_lawyer.pending]=this;
                    
                    
                    
                }}
            else if(category.equals("family")) {
                lawyer[] use=lawyer.family;
                lawyer my_lawyer=min_pending(use);
                System.out.println(my_lawyer.Name);
                
                if(my_lawyer.pending==-2) {
                    
                    
                    my_lawyer.current=this;
                    
                    current=my_lawyer;
                    my_lawyer.pending=-1;
                    
                }
                else {
                    pendingi=my_lawyer;
                    
                    my_lawyer.pending++;
                    
                    my_lawyer.pendings[my_lawyer.pending]=this;
                }
                
                
            }
            
        }
        
        
        
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Number of lawyers");
        int nlawyers=sc.nextInt();
        for(int c=0;c<nlawyers;c++) {
            String name=sc.next();
            String category=sc.next();
            lawyer obj=new lawyer(name , category);
            
        }
        
        int queries=sc.nextInt();
        for(int i=0;i<queries;i++) {
            int query=sc.nextInt();
            switch (query) {
                case 1:
                    String client_name=sc.next();
                    String client_category=sc.next();
                    int priority=sc.nextInt();
                    client obj_client=new client(client_name,client_category,priority);
                    int id=obj_client.client_id ;
                    System.out.println(" " +id);
                    
                    
                    
                    
                    
                    
                    break;
                case 2:
                    int id1=sc.nextInt();
                    lawyer temp=lawyer.hash[id1];
                    
                    
                    if(temp.pending<=0) {
                        System.out.print("no pending case");
                        break;
                    }
                    
                    
                    client next=lawyer.min_priority(temp);
                    System.out.print( next.name + " " +  next.category +  " "+ next.client_id  );
                    //System.out.println(next.name+ " " +next.category + " " + next.client_id);
                    
                    temp.pending--;
                    
                    
                    //System.out.println(next.name +next.category +next.client_id);
                    client[] pend=temp.pendings;
                    
                    for(int ui=0;ui<pend.length;ui++) {
                        if(pend[ui]==next) {
                            
                            for(int mn=ui;mn<pend.length-1;mn++) {
                                pend[mn]=pend[mn+1];
                                
                            }
                        }
                    }
                    temp.current=next;
                    break;
                case 3:
                    int id2=sc.nextInt();
                    lawyer temp1=lawyer.hash[id2];
                    
                    
                    client curr=temp1.current;
                    if(curr==null) {
                        System.out.print("no current case");
                        break;
                    }
                    
                    System.out.println(curr.name + " "+curr.category+ " " +curr.client_id);
                    break;
                    
                case 4:
                    int id3=sc.nextInt();
                    lawyer temp2=lawyer.hash[id3];
                    if(temp2.pending==-1 || temp2.pending==-2) {
                        System.out.println(" No pending");
                        break;
                        
                    }
                    client[] pendi=temp2.pendings;
                    int fgh=0;
                    while( fgh<pendi.length) {
                        
                        
                        client puggu=pendi[fgh];
                        
                        
                        if(puggu!=null){
                            
                            String cv=puggu.name;
                            
                            String category =puggu.category;
                            int idee=puggu.client_id;
                            System.out.println(cv + " " +category+" " + idee); }
                        
                        fgh++;
                    }
                    break;
                case 5:
                    for(int bn=0;bn<lawyer.cnt;bn++) {
                        lawyer cand=lawyer.all[bn];
                        System.out.println(cand.Name + " " +cand.category + " " +cand.lawyer_id);
                        
                        
                    }
                    break;
                case 6:
                    
                    int id4=sc.nextInt();
                    client temp4=client.hash[id4];
                    System.out.println(temp4.name + " " + "removed");
                    if(temp4.current!=null) {
                        temp4.current.current=lawyer.min_priority(temp4.current);
                        
                        
                        temp4.current.pending=temp4.current.pending-1;
                        
                        
                        int m=0;
                        while(temp4.current.pendings[m]!=null) {
                            
                            
                            m++;
                            if(temp4.current.pendings[m]==temp4.current.current) {
                                while(temp4.current.pendings[m+1]!=null) {
                                    client t=    temp4.current.pendings[m+1];
                                    temp4.current.pendings[m+1]=temp4.current.pendings[m];
                                    temp4.current.pendings[m]=t;
                                }
                            }
                        }
                        
                        
                        
                        
                        
                        
                        
                    }else {
                        lawyer clientss=temp4.current;
                        System.out.print(clientss.Name);
                        for(int m=0;m<clientss.pending+1;m++) {
                            if(clientss.pendings[m]==clientss.current) {
                                while(clientss.pendings[m+1]!=null) {
                                    client t=    clientss.pendings[m+1];
                                    clientss.pendings[m+1]=clientss.pendings[m];
                                    clientss.pendings[m]=t;
                                }
                            }
                        }
                        
                    }
                    
                    
            }
        }
        
        
        
        
    }}




// TODO Auto-generated method stub





