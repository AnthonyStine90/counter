package com.anthony.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Countercontroller {

  @RequestMapping("/")
  public String index() {
    return "index.jsp";
  }

  @RequestMapping("/counter")
  public String counter(HttpSession session, Model model) {

    Integer count = 0;

    if (session.getAttribute("count") == null) {
      session.setAttribute("count", 0);
    } else {
      count = (Integer) session.getAttribute("count");
      count++;
      session.setAttribute("count", count);
    }
    return "counter.jsp";
  }

  @RequestMapping("/countertwice")
  public String counterTwice(HttpSession session, Model model) {

    Integer count = 0;

    if (session.getAttribute("count") == null) {
      session.setAttribute("count", 0);
    } else {
      count = (Integer) session.getAttribute("count");
      count+=2;
      session.setAttribute("count", count);
    }
    return "counter.jsp";
  }

  @RequestMapping("/reset")
  public String reset(HttpSession session) {
    session.setAttribute("count", 0);
    return "index.jsp";
  }

  
}
