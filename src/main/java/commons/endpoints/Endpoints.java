package commons.endpoints;

//enum to define all the ednpoints that will follow baseurl
public enum  Endpoints {

    COMMON("/api/users");

    String path;

    Endpoints(String path){
        this.path=path;
    }

    public String getPath(){
        return this.path;
    }

}
