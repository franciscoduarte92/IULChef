/**********************************************************************
* Filename: CalendarDate.java
* Created: 2015/04/25
* @author Francisco Duarte & Hugo CHaves
**********************************************************************/
package org.quasar.IULChef.businessLayer;

import org.quasar.IULChef.persistenceLayer.Database;

import java.util.Set;

public class CalendarDate implements Comparable<Object>
{
	
	/***********************************************************
	* @return all instances of class CalendarDate
	***********************************************************/
	public static Set<CalendarDate> allInstances()
	{
		return Database.allInstances(CalendarDate.class);
	}
	
	private Integer day;
	private Integer month;
	private Integer year;
	
	/**********************************************************************
	* Default constructor
	**********************************************************************/
	public CalendarDate()
	{
	}
	
	/**********************************************************************
	* Parameterized constructor
	* @param day the day to initialize
	* @param month the month to initialize
	* @param year the year to initialize
	**********************************************************************/
	public CalendarDate(Integer day, Integer month, Integer year)
	{
		this.day = day;
		this.month = month;
		this.year = year;
		
		check();
		
		Database.insert(this);
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the day of the calendarDate
	**********************************************************************/
	public Integer day()
	{
		return day;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param day the day to set
	**********************************************************************/
	public void setDay(Integer day)
	{
		this.day = day;
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the month of the calendarDate
	**********************************************************************/
	public Integer month()
	{
		return month;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param month the month to set
	**********************************************************************/
	public void setMonth(Integer month)
	{
		this.month = month;
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the year of the calendarDate
	**********************************************************************/
	public Integer year()
	{
		return year;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param year the year to set
	**********************************************************************/
	public void setYear(Integer year)
	{
		this.year = year;
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	* @param day the day to set
	* @param month the month to set
	* @param year the year to set
	**********************************************************************/
	public void init(Integer day, Integer month, Integer year)
	{
		//	TODO conclude the implementation for this SOIL specification:
		//	self.day := day; self.month := month; self.year := year
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	* @param date the date to set
	**********************************************************************/
	public void initS(String date)
	{
		//	TODO conclude the implementation for this SOIL specification:
		//	self.year := date.substring(1,4).toInteger; self.month := date.substring(6,7).toInteger; self.day := date.substring(9,10).toInteger
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	* @param t the t to set
	**********************************************************************/
	public Boolean isAfter(CalendarDate t)
	{
		//	TODO conclude the implementation for this SOIL specification:
		//	return if (self.year = t.year) then if (self.month = t.month) then (self.day > t.day) else (self.month > t.month) endif else (self.year > t.year) endif
		return null;
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	* @param t the t to set
	**********************************************************************/
	public Boolean isBefore(CalendarDate t)
	{
		//	TODO conclude the implementation for this SOIL specification:
		//	return if (self.year = t.year) then if (self.month = t.month) then (self.day < t.day) else (self.month < t.month) endif else (self.year < t.year) endif
		return null;
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	* @param x the x to set
	* @param y the y to set
	**********************************************************************/
	public Boolean isDivisible(Integer x, Integer y)
	{
		//	TODO conclude the implementation for this SOIL specification:
		//	return (((x div y) * y) = x)
		return null;
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	* @param t the t to set
	**********************************************************************/
	public Boolean isEqual(CalendarDate t)
	{
		//	TODO conclude the implementation for this SOIL specification:
		//	return (((self.year = t.year) and (self.month = t.month)) and (self.day = t.day))
		return null;
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	**********************************************************************/
	public Boolean isLeap()
	{
		//	TODO conclude the implementation for this SOIL specification:
		//	return if (self.isDivisible(self.year, 400) or self.isDivisible(self.year, 4)) then true else if self.isDivisible(self.year, 100) then false else if self.isDivisible(self.year, 4) then true else false endif endif endif
		return null;
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	**********************************************************************/
	public Boolean isValid()
	{
		//	TODO conclude the implementation for this SOIL specification:
		//	return ((((self.month >= 1) and (self.month <= 12)) and (self.day >= 1)) and if self.isLeap() then (self.day <= Sequence {31,29,31,30,31,30,31,31,30,31,30,31}->at(self.month)) else (self.day <= Sequence {31,28,31,30,31,30,31,31,30,31,30,31}->at(self.month)) endif)
		return null;
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	* @param date the date to set
	**********************************************************************/
	public CalendarDate stringToDate(String date)
	{
		//	TODO conclude the implementation for this SOIL specification:
		//	declare date_year : String, date_month : String, date_day : String; date_year := date.substring(1,4); date_month := date.substring(6,7); date_day := date.substring(9,10); result := CalendarDate.allInstances->select(cd : CalendarDate | (((cd.year = date_year.toInteger) and (cd.month = date_month.toInteger)) and (cd.day = date_day.toInteger)))->asSequence->first; if result.isUndefined then result := new CalendarDate(((('D' + date_year) + date_month) + date_day)); result.initS(date) end
		return null;
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	**********************************************************************/
	public String toString()
	{
		//	TODO conclude the implementation for this SOIL specification:
		//	return self.year.toString.concat('/').concat(self.month.toString).concat('/').concat(self.day.toString)
		return null;
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	* @param t the t to set
	**********************************************************************/
	public Integer yearsSince(CalendarDate t)
	{
		//	TODO conclude the implementation for this SOIL specification:
		//	return if ((self.month < t.month) or ((self.month = t.month) and (self.day < t.day))) then ((self.year - t.year) - 1) else (self.year - t.year) endif
		return null;
	}
	
	/**********************************************************************
	* INVARIANT CHECKERS
	**********************************************************************/
	public void check()
	{
		checkDateIsValid();
		checkDatesAreDistinct();
	}
	
	public void checkDateIsValid()
	{
		//	TODO conclude the implementation of this OCL invariant:
		//	self.isValid()
		boolean invariant = true;
		
		assert invariant : "The current date must be a valid one";
	}
	
	public void checkDatesAreDistinct()
	{
		//	TODO conclude the implementation of this OCL invariant:
		//	CalendarDate.allInstances->isUnique($elem21 : CalendarDate | $elem21.toString())
		boolean invariant = true;
		
		assert invariant : "CalendarDate objects contain distinct dates";
	}
	
	/**********************************************************************
	* @param other CalendarDate to compare to the current one
	* @return 0 if the argument is equal to the current CalendarDate;
	* a value less than 0 if the argument is greater than the current CalendarDate;
	* and a value greater than 0 if the argument is less than this CalendarDate.
	**********************************************************************/
	@Override
	public int compareTo(Object other)
	{
		assert other instanceof CalendarDate;
		
		//	TODO: uncomment the option that is best suitable
		//	return this.day.compareTo(((CalendarDate) other).day);
		//	return this.month.compareTo(((CalendarDate) other).month);
		//	return this.year.compareTo(((CalendarDate) other).year);
		return this.hashCode() - ((CalendarDate) other).hashCode();
	}
	
	/**********************************************************************
	* @param other CalendarDate to check equality to the current one
	* @return true if the argument is equal to the current CalendarDate and false otherwise
	**********************************************************************/
	@Override
	public boolean equals(Object other)
	{
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (getClass() != other.getClass())
			return false;
		
		final CalendarDate another = (CalendarDate) other;
		if (!super.equals(another))
			return false;
		if ((this.day == null) ? (another.day != null) : !this.day.equals(another.day))
			return false;
		if ((this.month == null) ? (another.month != null) : !this.month.equals(another.month))
			return false;
		if ((this.year == null) ? (another.year != null) : !this.year.equals(another.year))
			return false;
		
		return true;
	}
	
}
