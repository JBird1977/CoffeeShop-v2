package com.JasonWestbrook.coffeeshop;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class CoffeeShopController
{
    //used for password encryption
    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private ItemDao itemDao;
    
    @RequestMapping("/")
    public ModelAndView index()
    {
        List<Item> listOfItems = itemDao.findAll();
        
        ModelAndView mav = new ModelAndView("index", "item", listOfItems);
        return mav;
    }
    
    @RequestMapping("/UserRegistration")
    public ModelAndView showUserRegistration()
    {
        ModelAndView mav = new ModelAndView("UserRegistration");
        return mav;
    }
    
    @PostMapping("/UserRegistration/Add")
    public ModelAndView addUser(User user, HttpSession session, RedirectAttributes redirect) throws NoSuchAlgorithmException
    {
        byte[] salt = createSalt();
        user.setSalt(salt);
        user.setPasswordHash(encryptPassword(user.getPassword(), user.getSalt()));
        user.setAdminRights(false);
        userDao.update(user);    
        redirect.addFlashAttribute("message", "New user added!");
        return new ModelAndView("redirect:/");
    }
    
    @RequestMapping("/login")
    public ModelAndView showLoginForm(HttpSession session, RedirectAttributes redirect)
    {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }
    
    @PostMapping("/login")
    public ModelAndView processLogin(HttpSession session, 
           RedirectAttributes redirect,
           @RequestParam(value="userName", required=true) String username,
           @RequestParam(value="password", required=true) String password)
    {       
        User user = userDao.findByUserName(username);
        if(user == null || !user.getPassword().equals(password))
        {
            redirect.addFlashAttribute("message", "Incorrect Username or Password");
            return new ModelAndView("redirect:/login");
        } else 
        {
            session.setAttribute("user", user);
            String welcomeMessage = ("Welcome back, " + user.firstName);
            redirect.addFlashAttribute("message", welcomeMessage);
            return new ModelAndView("redirect:/");
        }
    }
    
    
    @RequestMapping("/admin")
    public ModelAndView showAdminConsole(HttpSession session
           , RedirectAttributes redirect)
    { 
        
        if ( adminRightsCheck(session))
        {
            ModelAndView mav = new ModelAndView("admin");
            return mav;
        } else
        {
            ModelAndView mav = new ModelAndView("redirect:/");
            redirect.addFlashAttribute("message", "I'm sorry. Only admins can access this page.");
            return mav;
        }
    }
 
    
    @RequestMapping("/addItem")
    public ModelAndView showAddItem(HttpSession session,
           RedirectAttributes redirect)
    {
        
        if (adminRightsCheck(session))
        {
            ModelAndView mav = new ModelAndView("addItem");
            return mav;
        } else
        {
            ModelAndView mav = new ModelAndView("redirect:/");
            return mav;
        }
    }
    
    @PostMapping("/addItem")
    public ModelAndView processAddItem(HttpSession session,
            RedirectAttributes redirect, Item item)
    {
        
        itemDao.update(item);
        redirect.addFlashAttribute("message", "Item added!");
        ModelAndView mav = new ModelAndView("redirect:/admin");
        return mav;
    }
    
    @RequestMapping("/editItemConsole")
    public ModelAndView showEditItemConsole(HttpSession session
           , RedirectAttributes redirect, Item item)
    {
        
        
        if (adminRightsCheck(session))
        {
            List<Item> listOfItems = itemDao.findAll();
            ModelAndView mav = new ModelAndView("editItemConsole", "items", listOfItems);
            return mav;
        } else
        {
            ModelAndView mav = new ModelAndView("redirect:/");
            return mav;
        }
    }
    
    @PostMapping("/editItem")
    public ModelAndView processEditItem(HttpSession session
           , RedirectAttributes redirect,
           Item item)
    {
        
        ModelAndView mav = new ModelAndView("editItem");
        return mav;
    }
    
    public static byte[] createSalt()
    {
        byte[] bytes = new byte[20];
        SecureRandom random = new SecureRandom();
        random.nextBytes(bytes);
        return bytes;
    }
    
    public String encryptPassword(String password, byte[] salt) throws NoSuchAlgorithmException
    {
        String algorithm = "MD5";        
        return generateHash(password, algorithm, salt);
    }
       
    private static String generateHash(String data, String algorithm, byte[] salt) throws NoSuchAlgorithmException
    {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.reset();
        digest.update(salt);
        byte[] hash = digest.digest(data.getBytes());
        return bytesToStringHex(hash);
    }
    
    public static String bytesToStringHex(byte[] bytes)
    {
        char[] hexChars = new char[bytes.length * 2];
        for (int j=0; j < bytes.length; j++)
        {
            int v = bytes[j] & 0xFF;
            hexChars[j*2] = hexArray[v >>> 4];
        }
        
        return new String(hexChars);        
    }
    
    public boolean adminRightsCheck(HttpSession session)
    {
        User currentUser = (User) session.getAttribute("user");
        try 
        {
            if (currentUser.adminRights)
            {
                return true;
            } else
            { 
                return false;
            }
        } catch (NullPointerException e)
        {
            return false;
        }
    }    
}
