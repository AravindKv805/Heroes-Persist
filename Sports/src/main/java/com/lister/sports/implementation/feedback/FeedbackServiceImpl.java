/*	Heroes Persist
    Product which helps in organizing, broadcasting, celebrating events
    Copyright (C) 2014  Sai Pranav
    Email: rsaipranav92@gmail.com

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.lister.sports.implementation.feedback;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lister.sports.exception.SportsException;
import com.lister.sports.interfaces.feedback.FeedbackDao;
import com.lister.sports.interfaces.feedback.FeedbackService;
import com.lister.sports.model.Feedback;
import com.lister.sports.webservice.feedback.FeedbackForm;

/**
 * @author Sai Pranav
 *
 */

@Component
@Transactional
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	FeedbackDao feedbackDao;
	
	public int recordFeedback(FeedbackForm feedbackForm) throws SportsException, HibernateException{
		Feedback feedback = new Feedback();
		feedback.setEmail(feedbackForm.getEmail());
		feedback.setFeed(feedbackForm.getFeed());
		return feedbackDao.recordFeedback(feedback);
	}

}
