# Java_EE_Udemy25
Adding a Stateful Bean to the Session Context through Session Context Listener
To resolve the issue of a different Stateful EJB object being used for different Servlets 
I created a Web Listener called SessionListener and imported the @EJB CounterStatefulBean object.
Inside the sessionCreated method:

    HttpSession s = event.getSession();
    	
    s.setAttribute("cbStateful", cbStateful);
    
Inside BOTH the AddOne and ShowCount Servlets i deleted the @EJB import for the stateless EJB.
Inside the doGet methods:

    HttpSession s = request.getSession();
		
    CounterStatefulBean cbStateful = (CounterStatefulBean) s.getAttribute("cbStateful");
    
This enables the same Stateful Bean object to be used by both Servlets. This will work per session per user.



