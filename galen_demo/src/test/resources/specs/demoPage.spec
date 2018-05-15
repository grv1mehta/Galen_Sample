@import commonObjects.spec

@objects
    element1                  .hero
    element2                   .medium-hero
    element3                   .search-filters>div
    

=Home Page=

    @on desktop
        element1:
            inside entire-form 0px top 
            
        global-footer-main.logo-icon:   
            inside global-footer-main  
             
            
        global-footer-main.main-section:   
            inside global-footer-main  
               
        social-links:
            aligned horizontally top utility-links 
        
        utility-links:
            aligned horizontally top social-links  
            
        footer-section:
             below sign-up-for-email
             
        footer-section.app-store:
             css font-size is "12px"
             
        element3:
             inside entire-form  
             
        two-up-medium:
             below up-medium-quote-up-left 60px
             
        three-up-enhanced:
             below two-up-medium 70px
             
        one-up-medium-up-left-desc: 	     
             below three-up-enhanced 70px
             
      
    @on tablet
        global-header:
            inside entire-form
        
        global-footer-main.logo-icon:   
            inside global-footer-main  
            inside global-footer-main 
            
        global-footer-main.main-section:   
            inside global-footer-main  
            inside global-footer-main   
            
        social-links:
            aligned horizontally top utility-links 
        
        utility-links:
            aligned horizontally top social-links  
            
        footer-section:
             below sign-up-for-email
             
        footer-section.app-store:
             css font-size is "12px"
             
        up-medium-hero:
             below multimedia-hero 70px
             
             
        
    @on mobile
        global-header:
            inside entire-form
            
        global-footer-main.logo-icon:   
            inside global-footer-main  
            inside global-footer-main 
            
        global-footer-main.main-section:   
            inside global-footer-main  
            inside global-footer-main   
            
        utility-links:
            aligned vertically right social-links  
            
        footer-section:
             below sign-up-for-email
             
        footer-section.app-store:
             css font-size is "13px"
