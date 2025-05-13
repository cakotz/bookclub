package com.bookclub.web;

import jakarta.validation.Valid;
import com.bookclub.model.WishlistItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bookclub.service.dao.WishlistDao;
import com.bookclub.service.impl.MongoWishListDao;

import java.util.List;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {
    WishlistDao wishlistDao = new MongoWishListDao();

    @Autowired
    private void setWishlistDao(WishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showWishlist(Model model) {
        List<WishlistItem> wishlist = wishlistDao.list();

        model.addAttribute("wishlist", wishlist);

        return "wishlist/list";
    }

    @RequestMapping(method = RequestMethod.GET, path="/new")
    public String wishlistForm(Model model) {
        model.addAttribute("wishlistItem", new WishlistItem());
        return "wishlist/new";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addWishlistItem(@Valid WishlistItem wishlistItem, BindingResult bindingResult) {
        System.out.println(wishlistItem.toString());

        if (bindingResult.hasErrors()) {
            return "wishlist/new";
        }

        wishlistDao.add(wishlistItem);

        return "redirect:/wishlist";
    }
}
