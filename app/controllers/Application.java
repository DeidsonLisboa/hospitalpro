package controllers;

import play.*;
import play.mvc.*;
import java.util.*;

import annotations.Admin;
import models.*;

@Admin
@With(Seguranca.class)
public class Application extends Controller {
	   
    public static void inicio() {
        render();
     }

}