package service.impl;

import model.Book;
import model.WishlistItem;
import service.dao.BookDao;
import service.dao.WishlistDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemWishlistDao implements WishlistDao {
    private List<WishlistItem> wishlist = new ArrayList<>();

    public MemWishlistDao() {
        WishlistItem book1 = new WishlistItem("11", "wishlistOne");
        WishlistItem book2 = new WishlistItem("22", "wishlistTwo");


        wishlist.add(book1);
        wishlist.add(book2);
    }

    @Override
    public List<WishlistItem> list() {
        System.out.println(wishlist);
        return wishlist;
    }

    @Override
    public WishlistItem find(String key) {
        for (WishlistItem wishlistItem : this.wishlist) {
            if (wishlistItem.getIsbn().equals(key)) {
                return wishlistItem;
            }
        }
        return new WishlistItem();
    }
}
